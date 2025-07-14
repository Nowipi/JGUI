package testing;

import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGLGraphicsContext;

import java.lang.foreign.MemorySegment;

import static nowipi.opengl.OpenGL.*;

class HelloTriangle {

    private static final int SCR_WIDTH = 800;
    private static final int SCR_HEIGHT = 600;

    private static final String vertexShaderSource = "#version 330 core\nlayout (location = 0) in vec3 aPos;\nvoid main()\n{\n   gl_Position = vec4(aPos, 1.0);\n}";
    private static final String fragmentShaderSource = "#version 330 core\nout vec4 FragColor;\nvoid main()\n{\n   FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n}";

    public static void main(String[] args) {

        Window window = Window.createWindowed("Hello, Window!", SCR_WIDTH, SCR_HEIGHT);

        OpenGLGraphicsContext gc = OpenGL.createGraphicsContext(window);

        window.addListener((width, height) -> gc.glViewport(0, 0, width, height));


        int vertexShader = gc.glCreateShader(GL_VERTEX_SHADER);


        OpenGL.glShaderSource(gc, vertexShader, vertexShaderSource);
        gc.glCompileShader(vertexShader);
        if (!OpenGL.glGetShaderCompileStatus(gc, vertexShader)) {
            String infoLog = OpenGL.glGetShaderInfoLog(gc, vertexShader, 512);
            throw new RuntimeException("ERROR::SHADER::VERTEX::COMPILATION_FAILED\n" + infoLog);
        }

        int fragmentShader = gc.glCreateShader(GL_FRAGMENT_SHADER);
        OpenGL.glShaderSource(gc, fragmentShader, fragmentShaderSource);
        gc.glCompileShader(fragmentShader);
        if (!OpenGL.glGetShaderCompileStatus(gc, fragmentShader)) {
            throw new RuntimeException("ERROR::SHADER::FRAGMENT::COMPILATION_FAILED\n" + OpenGL.glGetShaderInfoLog(gc, fragmentShader, 512));
        }

        int shaderProgram = gc.glCreateProgram();
        gc.glAttachShader(shaderProgram, vertexShader);
        gc.glAttachShader(shaderProgram, fragmentShader);
        gc.glLinkProgram(shaderProgram);
        if (!OpenGL.glGetProgramLinkStatus(gc, shaderProgram)) {
            throw new RuntimeException("ERROR::SHADER::PROGRAM::LINKING_FAILED\n" + OpenGL.glGetProgramInfoLog(gc, shaderProgram, 512));
        }
        gc.glDeleteShader(vertexShader);
        gc.glDeleteShader(fragmentShader);


        float[] vertices = {
                0.5f,  0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                -0.5f,  0.5f, 0.0f
        };
        int[] indices = {
                0, 1, 3,
                1, 2, 3
        };
        int VAO = OpenGL.glGenVertexArray(gc);


        int VBO = OpenGL.glGenBuffer(gc);

        int EBO = OpenGL.glGenBuffer(gc);

        gc.glBindVertexArray(VAO);

        gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
        OpenGL.glBufferData(gc, GL_ARRAY_BUFFER,  vertices, GL_STATIC_DRAW);

        gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        OpenGL.glBufferData(gc, GL_ELEMENT_ARRAY_BUFFER,  indices, GL_STATIC_DRAW);

        gc.glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * Float.BYTES, 0);
        gc.glEnableVertexAttribArray(0);


        gc.glBindBuffer(GL_ARRAY_BUFFER, 0);

        gc.glBindVertexArray(0);

        window.show();

        while (!window.shouldClose()) {

            gc.glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
            gc.glClear(GL_COLOR_BUFFER_BIT);

            gc.glUseProgram(shaderProgram);
            gc.glBindVertexArray(VAO);
            gc.glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, MemorySegment.NULL);

            window.swapBuffers();

            window.pollEvents();
        }

        OpenGL.glDeleteVertexArray(gc, VAO);
        OpenGL.glDeleteBuffer(gc, VBO);
        OpenGL.glDeleteBuffer(gc, EBO);
        gc.glDeleteProgram(shaderProgram);
        gc.dispose();
        window.dispose();

    }

}
