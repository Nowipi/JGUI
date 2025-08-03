package nowipi.jgui.rendering;

import java.lang.foreign.MemorySegment;
import java.util.HashMap;
import java.util.Map;

import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.*;

import static nowipi.opengl.OpenGL.*;

public final class TextureRenderer implements Renderer {

    private final int shader;
    private final int VAO;
    private final int VBO;
    private final int EBO;

    private final OpenGLGraphicsContext gc;

    public TextureRenderer(Matrix4f projection, OpenGLGraphicsContext gc) {
        this.gc = gc;
        int vertexShader = gc.glCreateShader(GL_VERTEX_SHADER);
        String source = """
                #version 330 core
                layout (location = 0) in vec2 vPos;
                layout (location = 1) in vec2 vTex;
                
                out vec2 TexCoords;
                
                uniform mat4 projection;
                
                void main()
                {
                    TexCoords = vTex;
                    gl_Position = projection * vec4(vPos, 0.0, 1.0);
                }""";
        OpenGL.glShaderSource(gc, vertexShader, source);
        gc.glCompileShader(vertexShader);

        int fragmentShader = gc.glCreateShader(GL_FRAGMENT_SHADER);
        source = """
                #version 330 core
                in vec2 TexCoords;
                out vec4 color;
                
                uniform sampler2D image;
                uniform vec4 spriteColor;
                
                void main()
                {
                    color = spriteColor * texture(image, TexCoords);
                }""";
        OpenGL.glShaderSource(gc, fragmentShader, source);
        gc.glCompileShader(fragmentShader);

        shader = gc.glCreateProgram();
        gc.glAttachShader(shader, vertexShader);
        gc.glAttachShader(shader, fragmentShader);

        gc.glLinkProgram(shader);
        gc.glDeleteShader(vertexShader);
        gc.glDeleteShader(fragmentShader);


        gc.glUseProgram(shader);
        gc.glUniform1i(getUniform("image"), 0);

        setProjection(projection);


        VAO = OpenGL.glGenVertexArray(gc);
        VBO = OpenGL.glGenBuffer(gc);
        EBO =  OpenGL.glGenBuffer(gc);

        gc.glBindVertexArray(VAO);
        gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
        gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);


        gc.glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 4 * Float.BYTES, 0);
        gc.glEnableVertexAttribArray(0);

        gc.glVertexAttribPointer(1, 2, GL_FLOAT, GL_FALSE, 4 * Float.BYTES, 2 * Float.BYTES);
        gc.glEnableVertexAttribArray(1);

    }

    public void drawTexture(OpenGLTexture texture, Rectangle bounds) {
        drawTexture(texture, bounds, 255, 255, 255, 255);
    }

    public void drawTexture(OpenGLTexture texture, Rectangle bounds, float r, float g, float b, float a) {

        float[] vertexData = new float[16];
        int[] indexData = new int[6];
        int vertexDataIndex = 0;
        int indexDataIndex = 0;

        vertexData[vertexDataIndex++] = bounds.topLeft.x;
        vertexData[vertexDataIndex++] = bounds.topLeft.y;
        vertexData[vertexDataIndex++] = 0;
        vertexData[vertexDataIndex++] = 1;

        vertexData[vertexDataIndex++] = bounds.topRight.x;
        vertexData[vertexDataIndex++] = bounds.topRight.y;
        vertexData[vertexDataIndex++] = 1;
        vertexData[vertexDataIndex++] = 1;

        vertexData[vertexDataIndex++] = bounds.bottomRight.x;
        vertexData[vertexDataIndex++] = bounds.bottomRight.y;
        vertexData[vertexDataIndex++] = 1;
        vertexData[vertexDataIndex++] = 0;

        vertexData[vertexDataIndex++] = bounds.bottomLeft.x;
        vertexData[vertexDataIndex++] = bounds.bottomLeft.y;
        vertexData[vertexDataIndex++] = 0;
        vertexData[vertexDataIndex] = 0;


        indexData[indexDataIndex++] = 0;
        indexData[indexDataIndex++] = 1;
        indexData[indexDataIndex++] = 2;

        indexData[indexDataIndex++] = 0;
        indexData[indexDataIndex++] = 2;
        indexData[indexDataIndex] = 3;




        gc.glBindVertexArray(VAO);
        gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
        OpenGL.glBufferData(gc, GL_ARRAY_BUFFER, vertexData, GL_DYNAMIC_DRAW);

        gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        OpenGL.glBufferData(gc, GL_ELEMENT_ARRAY_BUFFER, indexData, GL_DYNAMIC_DRAW);

        gc.glUseProgram(shader);

        // render textured quad
        gc.glUniform4f(getUniform("spriteColor"), r / 255f, g / 255f, b / 255f, a / 255f);

        gc.glActiveTexture(OpenGL.GL_TEXTURE0);
        texture.bind();

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
        OpenGL.glDeleteBuffer(gc, VBO);
        OpenGL.glDeleteBuffer(gc, EBO);
        OpenGL.glDeleteVertexArray(gc, VAO);
        gc.glDeleteProgram(shader);
    }

    @Override
    public void beginFrame() {

    }

    @Override
    public void endFrame() {

    }
}
