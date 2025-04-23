package testing;

import nowipi.jgui.window.Disposable;

import java.lang.foreign.MemorySegment;
import java.util.HashMap;
import java.util.Map;

import static nowipi.jgui.opengl.OpenGL.*;

final class TextureRenderer implements Renderer, Disposable {

    private static final int shader;

    static {
        int vertexShader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShader, "#version 330 core\n" +
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
        glCompileShader(vertexShader);

        int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShader, "#version 330 core\n" +
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
        glCompileShader(fragmentShader);

        shader = glCreateProgram();
        glAttachShader(shader, vertexShader);
        glAttachShader(shader, fragmentShader);

        glLinkProgram(shader);
        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);
    }

    private final int quadVAO;

    public TextureRenderer() {
        int VBO;
        int EBO;
        float[] vertices = {
                // pos      // tex
                0.0f, 1.0f, 0.0f, 1.0f,
                1.0f, 0.0f, 1.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f,
                1.0f, 1.0f, 1.0f, 1.0f,
        };

        int[] indices = {
                0, 1, 2,
                0, 3, 1
        };

        quadVAO = glGenVertexArrays();
        VBO = glGenBuffers();
        EBO = glGenBuffers();

        glBindVertexArray(quadVAO);

        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 4, GL_FLOAT, false, 4 * Float.BYTES, MemorySegment.NULL);
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);


        glUseProgram(shader);
        glUniform1i(getUniform(shader, "image"), 0);
    }

    public void drawTexture(OpenGLTexture texture, int x, int y, int width, int height, float rotation, float r, float g, float b, float a) {
        glUseProgram(shader);
        var model = Matrix4f.identity();
        model = Matrix4f.translate(model, x, y, 0);

        model = Matrix4f.translate(model, 0.5f * width, 0.5f * height, 0);
        model = Matrix4f.rotate(model, (float) Math.toRadians(rotation), Axis.Z);
        model = Matrix4f.translate(model, -0.5f * width, -0.5f * height, 0);

        model = Matrix4f.scale(model, width, height, 1); // last scale

        glUniformMatrix4fv(getUniform(shader, "model"), 1, false, model.toArray());

        // render textured quad
        glUniform4f(getUniform(shader, "spriteColor"), r, g, b, a);

        glActiveTexture(GL_TEXTURE0);
        texture.bind();

        drawFrame();
    }

    private final Map<String, Integer> uniforms = new HashMap<>();
    private int getUniform(int shader, String name) {
        Integer uniform = uniforms.get(name);
        if (uniform == null) {
            uniform = glGetUniformLocation(shader, name);
            uniforms.put(name, uniform);
        }
        return uniform;
    }

    public void setProjection(Matrix4f projection) {
        glUseProgram(shader);
        glUniformMatrix4fv(getUniform(shader, "projection"), 1, false, projection.toArray());
    }

    @Override
    public void dispose() {
        glDeleteVertexArrays(quadVAO);
    }

    @Override
    public void beginFrame() {

    }

    @Override
    public void drawFrame() {
        glBindVertexArray(quadVAO);
        glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, MemorySegment.NULL);
        glBindVertexArray(0);
    }

    @Override
    public void endFrame() {

    }
}
