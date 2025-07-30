package nowipi.jgui.rendering;

import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Quad;
import nowipi.primitives.Vector2f;

import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;

import static nowipi.opengl.OpenGL.*;

public final class BatchedQuadRenderer implements Renderer {

    private final int shader;
    private final int projectionUniformLocation;

    private record QuadDrawCommand(Quad quad, float r, float g, float b, float a) {}

    private final OpenGLGraphicsContext gc;
    private final int VAO;
    private final int VBO;
    private final int EBO;
    private final List<QuadDrawCommand> quads;

    public BatchedQuadRenderer(Matrix4f projectionMatrix, OpenGLGraphicsContext gc) {

        int vertexShader = gc.glCreateShader(OpenGL.GL_VERTEX_SHADER);
        String source = """
                #version 330 core
                layout (location = 0) in vec2 vPosition;
                layout (location = 1) in vec4 vColor;
                
                uniform mat4 projection;
                
                out vec4 fColor;
                
                void main()
                {
                    fColor = vColor / 255.0f;
                    gl_Position = projection * vec4(vPosition, 0.0, 1.0);
                }""";
        OpenGL.glShaderSource(gc, vertexShader, source);

        gc.glCompileShader(vertexShader);

        int fragmentShader = gc.glCreateShader(OpenGL.GL_FRAGMENT_SHADER);
        source = """
                #version 330 core
                in vec4 fColor;
                out vec4 color;
                
                void main()
                {
                    if(fColor.a < 0.1)
                        discard;
                    color = fColor;
                }""";
        OpenGL.glShaderSource(gc, fragmentShader, source);
        gc.glCompileShader(fragmentShader);

        shader = gc.glCreateProgram();
        gc.glAttachShader(shader, vertexShader);
        gc.glAttachShader(shader, fragmentShader);

        gc.glLinkProgram(shader);
        gc.glDeleteShader(vertexShader);
        gc.glDeleteShader(fragmentShader);


        projectionUniformLocation = OpenGL.glGetUniformLocation(gc, shader, "projection");

        this.gc = gc;

        quads = new ArrayList<>(10);

        setProjection(projectionMatrix);

        VAO = OpenGL.glGenVertexArray(gc);
        gc.glBindVertexArray(VAO);

        VBO = OpenGL.glGenBuffer(gc);
        EBO = OpenGL.glGenBuffer(gc);
        gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
        gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        gc.glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 6 * Float.BYTES, 0);
        gc.glEnableVertexAttribArray(0);

        gc.glVertexAttribPointer(1, 4, GL_FLOAT, GL_FALSE, 6 * Float.BYTES, 2 * Float.BYTES);
        gc.glEnableVertexAttribArray(1);


        gc.glBindBuffer(GL_ARRAY_BUFFER, 0);
        gc.glBindVertexArray(0);
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

            for (Vector2f vertex : command.quad.vertices()) {
                vertexData[vertexDataIndex++] = vertex.x;
                vertexData[vertexDataIndex++] = vertex.y;
                vertexData[vertexDataIndex++] = command.r();
                vertexData[vertexDataIndex++] = command.g();
                vertexData[vertexDataIndex++] = command.b();
                vertexData[vertexDataIndex++] = command.a();
            }

            int vertexBase = i * 4;
            indexData[indexDataIndex++] = vertexBase + 0;
            indexData[indexDataIndex++] = vertexBase + 1;
            indexData[indexDataIndex++] = vertexBase + 2;

            indexData[indexDataIndex++] = vertexBase + 0;
            indexData[indexDataIndex++] = vertexBase + 2;
            indexData[indexDataIndex++] = vertexBase + 3;
        }


        gc.glBindVertexArray(VAO);
        gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
        OpenGL.glBufferData(gc, GL_ARRAY_BUFFER, vertexData, GL_DYNAMIC_DRAW);

        gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        OpenGL.glBufferData(gc, GL_ELEMENT_ARRAY_BUFFER, indexData, GL_DYNAMIC_DRAW);

        gc.glUseProgram(shader);
        gc.glDrawElements(GL_TRIANGLES, 6 * rectangleCount, GL_UNSIGNED_INT, MemorySegment.ofAddress(0));
    }

    public void setProjection(Matrix4f projection) {
        gc.glUseProgram(shader);
        OpenGL.glUniformMatrix4fv(gc, projectionUniformLocation, false, projection.toArray());
    }


}