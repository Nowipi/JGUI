package nowipi.jgui.rendering;

import nowipi.opengl.OpenGL;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Quad;

import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;

import static nowipi.opengl.OpenGL.*;

public final class BatchedQuadRenderer implements Renderer {

    private static final int shader;
    private static final int projectionUniformLocation;

    static {
        int vertexShader = OpenGL.glCreateShader(OpenGL.GL_VERTEX_SHADER);
        OpenGL.glShaderSource(vertexShader, """
                #version 330 core
                layout (location = 0) in vec2 vPosition;
                layout (location = 1) in vec4 vColor;
                
                uniform mat4 projection;
                
                out vec4 fColor;
                
                void main()
                {
                    fColor = vColor / 255.0f;
                    gl_Position = projection * vec4(vPosition, 0.0, 1.0);
                }""");
        OpenGL.glCompileShader(vertexShader);

        int fragmentShader = OpenGL.glCreateShader(OpenGL.GL_FRAGMENT_SHADER);
        OpenGL.glShaderSource(fragmentShader, """
                #version 330 core
                in vec4 fColor;
                out vec4 color;
                
                void main()
                {
                    if(fColor.a < 0.1)
                        discard;
                    color = fColor;
                }""");
        OpenGL.glCompileShader(fragmentShader);

        shader = OpenGL.glCreateProgram();
        OpenGL.glAttachShader(shader, vertexShader);
        OpenGL.glAttachShader(shader, fragmentShader);

        OpenGL.glLinkProgram(shader);
        OpenGL.glDeleteShader(vertexShader);
        OpenGL.glDeleteShader(fragmentShader);

        projectionUniformLocation = OpenGL.glGetUniformLocation(shader, "projection");
    }

    private record QuadDrawCommand(Quad quad, float r, float g, float b, float a) {}

    private final int VAO;
    private final int VBO;
    private final int EBO;
    private final List<QuadDrawCommand> quads;

    public BatchedQuadRenderer(Matrix4f projectionMatrix) {

        quads = new ArrayList<>(10);

        setProjection(projectionMatrix);

        VAO = glGenVertexArrays();
        glBindVertexArray(VAO);

        VBO = glGenBuffers();
        EBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 6 * Float.BYTES, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, 4, GL_FLOAT, GL_FALSE, 6 * Float.BYTES, 2 * Float.BYTES);
        glEnableVertexAttribArray(1);


        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    /**
     * Draws a quad to the screen.
     * @param quad the quad in screen coordinates
     * @param r
     * @param g
     * @param b
     * @param a
     */
    public void drawQuad(Quad quad, float r, float g, float b, float a) {
        quads.add(new QuadDrawCommand(quad, r, g, b, a));
    }

    @Override
    public void beginFrame() {
        quads.clear();
    }

    @Override
    public void endFrame() {

        int rectangleCount = quads.size();
        float[] vertexData = new float[rectangleCount * 6 * 4];
        int[] indexData = new int[rectangleCount * 6];
        int vertexDataIndex = 0;
        int indexDataIndex = 0;
        for (int i = 0; i < quads.size(); i++) {
            var command = quads.get(i);
            var quad = command.quad;
            vertexData[vertexDataIndex++] = quad.topLeft.x;
            vertexData[vertexDataIndex++] = quad.topLeft.y;
            vertexData[vertexDataIndex++] = command.r();
            vertexData[vertexDataIndex++] = command.g();
            vertexData[vertexDataIndex++] = command.b();
            vertexData[vertexDataIndex++] = command.a();

            vertexData[vertexDataIndex++] = quad.topRight.x;
            vertexData[vertexDataIndex++] = quad.topRight.y;
            vertexData[vertexDataIndex++] = command.r();
            vertexData[vertexDataIndex++] = command.g();
            vertexData[vertexDataIndex++] = command.b();
            vertexData[vertexDataIndex++] = command.a();

            vertexData[vertexDataIndex++] = quad.bottomRight.x;
            vertexData[vertexDataIndex++] = quad.bottomRight.y;
            vertexData[vertexDataIndex++] = command.r();
            vertexData[vertexDataIndex++] = command.g();
            vertexData[vertexDataIndex++] = command.b();
            vertexData[vertexDataIndex++] = command.a();

            vertexData[vertexDataIndex++] = quad.bottomLeft.x;
            vertexData[vertexDataIndex++] = quad.bottomLeft.y;
            vertexData[vertexDataIndex++] = command.r();
            vertexData[vertexDataIndex++] = command.g();
            vertexData[vertexDataIndex++] = command.b();
            vertexData[vertexDataIndex++] = command.a();

            int vertexBase = i * 4;
            indexData[indexDataIndex++] = vertexBase + 0;
            indexData[indexDataIndex++] = vertexBase + 1;
            indexData[indexDataIndex++] = vertexBase + 2;

            indexData[indexDataIndex++] = vertexBase + 0;
            indexData[indexDataIndex++] = vertexBase + 2;
            indexData[indexDataIndex++] = vertexBase + 3;
        }


        OpenGL.glBindVertexArray(VAO);
        OpenGL.glBindBuffer(OpenGL.GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, vertexData, GL_DYNAMIC_DRAW);

        OpenGL.glBindBuffer(OpenGL.GL_ELEMENT_ARRAY_BUFFER, EBO);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexData, GL_DYNAMIC_DRAW);

        OpenGL.glUseProgram(shader);
        OpenGL.glDrawElements(GL_TRIANGLES, 6 * rectangleCount, GL_UNSIGNED_INT, MemorySegment.ofAddress(0));
    }

    public void setProjection(Matrix4f projection) {
        OpenGL.glUseProgram(shader);
        OpenGL.glUniformMatrix4fv(projectionUniformLocation, 1, GL_FALSE, projection.toArray());
    }
}