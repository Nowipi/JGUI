package nowipi.jgui.rendering;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.HashMap;
import java.util.Map;

import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Axis;
import nowipi.primitives.Matrix4f;

import static nowipi.opengl.OpenGL.*;

//TODO Rework TextureRenderer using batching and Quad or Rectangle class
@Deprecated
public final class TextureRenderer implements Renderer {

    private final int shader;
    private static final float[] vertices = {
            // pos      // tex
            0.0f, 1.0f, 0.0f, 1.0f,
            1.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
    };
    private static final int[] indices = {
            0, 1, 2,
            0, 3, 1
    };

    private final int quadVAO;
    private final OpenGLGraphicsContext gc;

    public TextureRenderer(Matrix4f projection, OpenGLGraphicsContext gc) {
        this.gc = gc;
        int vertexShader = gc.glCreateShader(GL_VERTEX_SHADER);
        String source = "#version 330 core\n" +
                "layout (location = 0) in vec4 vertex; // <vec2 position, vec2 texCoords>\n" +
                "\n" +
                "out vec2 TexCoords;\n" +
                "\n" +
                "uniform mat4 model;\n" +
                "uniform mat4 projection;\n" +
                "\n" +
                "void main()\n" +
                "{\n" +
                "    TexCoords = vertex.zw;\n" +
                "    gl_Position = projection * model * vec4(vertex.xy, 0.0, 1.0);\n" +
                "}";
        OpenGL.glShaderSource(gc, vertexShader, source);
        gc.glCompileShader(vertexShader);

        int fragmentShader = gc.glCreateShader(GL_FRAGMENT_SHADER);
        source = "#version 330 core\n" +
                "in vec2 TexCoords;\n" +
                "out vec4 color;\n" +
                "\n" +
                "uniform sampler2D image;\n" +
                "uniform vec4 spriteColor;\n" +
                "\n" +
                "void main()\n" +
                "{    \n" +
                "    color = spriteColor * texture(image, TexCoords);\n" +
                "}";
        OpenGL.glShaderSource(gc, fragmentShader, source);
        gc.glCompileShader(fragmentShader);

        shader = gc.glCreateProgram();
        gc.glAttachShader(shader, vertexShader);
        gc.glAttachShader(shader, fragmentShader);

        gc.glLinkProgram(shader);
        gc.glDeleteShader(vertexShader);
        gc.glDeleteShader(fragmentShader);


        quadVAO = OpenGL.glGenVertexArray(gc);

        int VBO = OpenGL.glGenBuffer(gc);

        int EBO =  OpenGL.glGenBuffer(gc);

        gc.glBindVertexArray(quadVAO);

        gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
        OpenGL.glBufferData(gc, GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        OpenGL.glBufferData(gc, GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);


        gc.glVertexAttribPointer(0, 4, GL_FLOAT, GL_FALSE, 4 * Float.BYTES, 0);
        gc.glEnableVertexAttribArray(0);

        gc.glBindBuffer(GL_ARRAY_BUFFER, 0);
        gc.glBindVertexArray(0);


        gc.glUseProgram(shader);
        gc.glUniform1i(getUniform("image"), 0);

        setProjection(projection);

    }

    public void drawTexture(OpenGLTexture texture, int leftX, int topY, int width, int height, float rotation, float r, float g, float b, float a) {
        gc.glUseProgram(shader);
        var model = Matrix4f.identity();

        model = Matrix4f.translate(model, 0.5f * width, 0.5f * height, 0);

        model = Matrix4f.translate(model, leftX, topY, 0);

        model = Matrix4f.rotate(model, (float) Math.toRadians(rotation), Axis.Z);

        model = Matrix4f.scale(model, width, height, 1);


        OpenGL.glUniformMatrix4fv(gc, getUniform("model"), false, model.toArray());

        // render textured quad
        gc.glUniform4f(getUniform("spriteColor"), r, g, b, a);

        gc.glActiveTexture(OpenGL.GL_TEXTURE0);
        texture.bind();

        gc.glBindVertexArray(quadVAO);
        gc.glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, MemorySegment.NULL);
    }

    private final Map<String, Integer> uniforms = new HashMap<>();
    private int getUniform(String name) {
        Integer uniform = uniforms.get(name);
        if (uniform == null) {
            uniform = OpenGL.glGetUniformLocation(gc, shader, name);
            uniforms.put(name, uniform);
        }
        return uniform;
    }

    public void setProjection(Matrix4f projection) {
        gc.glUseProgram(shader);
        OpenGL.glUniformMatrix4fv(gc, getUniform("projection"), false, projection.toArray());
    }

    public void dispose() {
        try(var arena = Arena.ofConfined()) {
            gc.glDeleteVertexArrays(1, arena.allocateFrom(ValueLayout.JAVA_INT, quadVAO));
        }
    }

    @Override
    public void beginFrame() {

    }

    @Override
    public void endFrame() {

    }
}
