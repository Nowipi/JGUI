package nowipi.jgui.rendering;

import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGL;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Quad;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.List;

import static nowipi.opengl.OpenGL.*;

public final class BatchedQuadRenderer implements Renderer {

    private final int shader;
    private final int projectionUniformLocation;

    private record QuadDrawCommand(Quad quad, float r, float g, float b, float a) {}

    private final GraphicsContext gc;
    private final int VAO;
    private final int VBO;
    private final int EBO;
    private final List<QuadDrawCommand> quads;

    public BatchedQuadRenderer(Matrix4f projectionMatrix, GraphicsContext gc) {

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
        try(var arena = Arena.ofConfined()) {
            gc.glShaderSource(vertexShader, 1, arena.allocateFrom(source), arena.allocateFrom(ValueLayout.JAVA_INT, source.length()));

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
            gc.glShaderSource(vertexShader, 1, arena.allocateFrom(source), arena.allocateFrom(ValueLayout.JAVA_INT, source.length()));
            gc.glCompileShader(fragmentShader);

            shader = gc.glCreateProgram();
            gc.glAttachShader(shader, vertexShader);
            gc.glAttachShader(shader, fragmentShader);

            gc.glLinkProgram(shader);
            gc.glDeleteShader(vertexShader);
            gc.glDeleteShader(fragmentShader);


            projectionUniformLocation = gc.glGetUniformLocation(shader, arena.allocateFrom("projection"));

            this.gc = gc;

            quads = new ArrayList<>(10);

            setProjection(projectionMatrix);

            MemorySegment VAOP = arena.allocateFrom(ValueLayout.JAVA_INT);
            gc.glGenVertexArrays(1, VAOP);
            VAO = VAOP.get(ValueLayout.JAVA_INT, 0);
            gc.glBindVertexArray(VAO);

            MemorySegment VBOP = arena.allocateFrom(ValueLayout.JAVA_INT);
            gc.glGenBuffers(1, VBOP);
            VBO = VBOP.get(ValueLayout.JAVA_INT, 0);
            MemorySegment EBOP = arena.allocateFrom(ValueLayout.JAVA_INT);
            gc.glGenBuffers(1, EBOP);
            EBO = EBOP.get(ValueLayout.JAVA_INT, 0);
        }
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


        gc.glBindVertexArray(VAO);
        gc.glBindBuffer(OpenGL.GL_ARRAY_BUFFER, VBO);
        gc.glBufferData(GL_ARRAY_BUFFER, vertexData.length, MemorySegment.ofArray(vertexData), GL_DYNAMIC_DRAW);

        gc.glBindBuffer(OpenGL.GL_ELEMENT_ARRAY_BUFFER, EBO);
        gc.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexData.length, MemorySegment.ofArray(indexData), GL_DYNAMIC_DRAW);

        gc.glUseProgram(shader);
        gc.glDrawElements(GL_TRIANGLES, 6 * rectangleCount, GL_UNSIGNED_INT, MemorySegment.ofAddress(0));
    }

    public void setProjection(Matrix4f projection) {
        gc.glUseProgram(shader);
        gc.glUniformMatrix4fv(projectionUniformLocation, 1, GL_FALSE, MemorySegment.ofArray(projection.toArray()));
    }
}