package nowipi.jgui.rendering;

import java.lang.foreign.MemorySegment;
import java.util.HashMap;
import java.util.Map;

import nowipi.opengl.OpenGL;
import nowipi.primitives.Axis;
import nowipi.primitives.Matrix4f;

public final class TextureRenderer implements Renderer {

    private static final int shader;
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

    static {
        int vertexShader = OpenGL.glCreateShader(OpenGL.GL_VERTEX_SHADER);
        OpenGL.glShaderSource(vertexShader, "#version 330 core\n" +
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
                "}");
        OpenGL.glCompileShader(vertexShader);

        int fragmentShader = OpenGL.glCreateShader(OpenGL.GL_FRAGMENT_SHADER);
        OpenGL.glShaderSource(fragmentShader, "#version 330 core\n" +
                "in vec2 TexCoords;\n" +
                "out vec4 color;\n" +
                "\n" +
                "uniform sampler2D image;\n" +
                "uniform vec4 spriteColor;\n" +
                "\n" +
                "void main()\n" +
                "{    \n" +
                "    color = spriteColor * texture(image, TexCoords);\n" +
                "}");
        OpenGL.glCompileShader(fragmentShader);

        shader = OpenGL.glCreateProgram();
        OpenGL.glAttachShader(shader, vertexShader);
        OpenGL.glAttachShader(shader, fragmentShader);

        OpenGL.glLinkProgram(shader);
        OpenGL.glDeleteShader(vertexShader);
        OpenGL.glDeleteShader(fragmentShader);
    }

    private final int quadVAO;

    public TextureRenderer() {
        quadVAO = OpenGL.glGenVertexArrays();
        int VBO = OpenGL.glGenBuffers();
        int EBO = OpenGL.glGenBuffers();

        OpenGL.glBindVertexArray(quadVAO);

        OpenGL.glBindBuffer(OpenGL.GL_ARRAY_BUFFER, VBO);
        OpenGL.glBufferData(OpenGL.GL_ARRAY_BUFFER, vertices, OpenGL.GL_STATIC_DRAW);

        OpenGL.glBindBuffer(OpenGL.GL_ELEMENT_ARRAY_BUFFER, EBO);
        OpenGL.glBufferData(OpenGL.GL_ELEMENT_ARRAY_BUFFER, indices, OpenGL.GL_STATIC_DRAW);

        OpenGL.glVertexAttribPointer(0, 4, OpenGL.GL_FLOAT, false, 4 * Float.BYTES, MemorySegment.NULL);
        OpenGL.glEnableVertexAttribArray(0);

        OpenGL.glBindBuffer(OpenGL.GL_ARRAY_BUFFER, 0);
        OpenGL.glBindVertexArray(0);


        OpenGL.glUseProgram(shader);
        OpenGL.glUniform1i(getUniform(shader, "image"), 0);
    }

    public void drawTexture(OpenGLTexture texture, int x, int y, int width, int height, float rotation, float r, float g, float b, float a) {
        OpenGL.glUseProgram(shader);
        var model = Matrix4f.identity();
        model = Matrix4f.translate(model, x, y, 0);

        model = Matrix4f.translate(model, 0.5f * width, 0.5f * height, 0);
        model = Matrix4f.rotate(model, (float) Math.toRadians(rotation), Axis.Z);
        model = Matrix4f.translate(model, -0.5f * width, -0.5f * height, 0);

        model = Matrix4f.scale(model, width, height, 1); // last scale

        OpenGL.glUniformMatrix4fv(getUniform(shader, "model"), 1, false, model.toArray());

        // render textured quad
        OpenGL.glUniform4f(getUniform(shader, "spriteColor"), r, g, b, a);

        OpenGL.glActiveTexture(OpenGL.GL_TEXTURE0);
        texture.bind();

        drawFrame();
    }

    private final Map<String, Integer> uniforms = new HashMap<>();
    private int getUniform(int shader, String name) {
        Integer uniform = uniforms.get(name);
        if (uniform == null) {
            uniform = OpenGL.glGetUniformLocation(shader, name);
            uniforms.put(name, uniform);
        }
        return uniform;
    }

    public void setProjection(Matrix4f projection) {
        OpenGL.glUseProgram(shader);
        OpenGL.glUniformMatrix4fv(getUniform(shader, "projection"), 1, false, projection.toArray());
    }

    public void dispose() {
        OpenGL.glDeleteVertexArrays(quadVAO);
    }

    @Override
    public void beginFrame() {

    }

    @Override
    public void drawFrame() {
        OpenGL.glBindVertexArray(quadVAO);
        OpenGL.glDrawElements(OpenGL.GL_TRIANGLES, 6, OpenGL.GL_UNSIGNED_INT, MemorySegment.NULL);
    }

    @Override
    public void endFrame() {

    }
}
