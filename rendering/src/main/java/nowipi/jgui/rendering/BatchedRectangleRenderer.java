package nowipi.jgui.rendering;

import nowipi.jgui.components.styling.Color;
import nowipi.opengl.OpenGL;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;

import java.lang.foreign.MemorySegment;
import java.util.Arrays;

import static nowipi.opengl.OpenGL.*;

public final class BatchedRectangleRenderer implements Renderer {

    private static final int shader;
    private static final int projectionUniformLocation;

    private static final float[] vertexPositions = {
            -0.05f,  0.05f,
            0.05f, -0.05f,
            -0.05f, -0.05f,

            -0.05f,  0.05f,
            0.05f, -0.05f,
            0.05f,  0.05f,
    };

    static {
        int vertexShader = OpenGL.glCreateShader(OpenGL.GL_VERTEX_SHADER);
        OpenGL.glShaderSource(vertexShader, """
                #version 330 core
                layout (location = 0) in vec2 aPosition;
                layout (location = 1) in vec4 iColor;
                layout (location = 2) in mat4 iModel;
                
                uniform mat4 projection;
                
                out vec4 fColor;
                
                void main()
                {
                    fColor = iColor;
                    gl_Position = projection * iModel * vec4(aPosition, 0.0, 1.0);
                }""");
        OpenGL.glCompileShader(vertexShader);

        int fragmentShader = OpenGL.glCreateShader(OpenGL.GL_FRAGMENT_SHADER);
        OpenGL.glShaderSource(fragmentShader, """
                #version 330 core
                in vec4 fColor;
                out vec4 color;
                
                void main()
                {
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

    private final int VAO;
    private final int instanceVBO ;
    private int rectangleCount;

    public BatchedRectangleRenderer(Matrix4f projectionMatrix) {

        setProjection(projectionMatrix);

        VAO = glGenVertexArrays();
        glBindVertexArray(VAO);

        int VBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, vertexPositions, GL_STATIC_DRAW);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 2 * Float.BYTES, MemorySegment.ofAddress(0));
        glEnableVertexAttribArray(0);

        instanceVBO  = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, instanceVBO);
        glBufferData(GL_ARRAY_BUFFER,  5 * 20 * Float.BYTES, MemorySegment.NULL, GL_DYNAMIC_DRAW);

        glVertexAttribPointer(1, 4, GL_FLOAT, false, 20 * Float.BYTES, MemorySegment.ofAddress(0));
        glEnableVertexAttribArray(1);
        glVertexAttribDivisor(1, 1);

        for (int i = 0; i < 4; i++) {
            glVertexAttribPointer(2 + i, 4, GL_FLOAT, false, 20 * Float.BYTES, MemorySegment.ofAddress(i * 4 * Float.BYTES));
            glEnableVertexAttribArray(2 + i);
            glVertexAttribDivisor(2 + i, 1);
        }


        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    public void drawRectangle(Rectangle rectangle, Color color) {
        float[] vertexData = {
                color.r(), color.g(), color.b(), color.a(),
                rectangle.width(), 0, 0, 0,
                0, rectangle.height(),0, 0,
                0, 0, 1, 0,
                rectangle.topLeft.x, rectangle.topLeft.y, 0, 1,
        };

        System.out.println(Arrays.toString(vertexData));

        OpenGL.glBindBuffer(OpenGL.GL_ARRAY_BUFFER, instanceVBO);
        OpenGL.glBufferSubData(OpenGL.GL_ARRAY_BUFFER, rectangleCount * 20 * Float.BYTES, vertexData);
        rectangleCount++;
    }

    @Override
    public void beginFrame() {
        rectangleCount = 0;

    }

    @Override
    public void drawFrame() {

    }

    @Override
    public void endFrame() {
        OpenGL.glUseProgram(shader);
        OpenGL.glBindVertexArray(VAO);
        OpenGL.glDrawArraysInstanced(GL_TRIANGLES, 0, 6, rectangleCount);
    }

    public void setProjection(Matrix4f projection) {
        OpenGL.glUseProgram(shader);
        OpenGL.glUniformMatrix4fv(projectionUniformLocation, 1, false, projection.toArray());
    }
}