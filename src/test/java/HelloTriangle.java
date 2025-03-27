import nowipi.rendering.GraphicsContext;
import nowipi.rendering.OpenGL;
import nowipi.rendering.WGLGraphicsContext;
import nowipi.windowing.win32.GDIDrawingSurface;
import nowipi.windowing.win32.Win32Window;
import nowipi.windowing.Window;

import java.lang.foreign.MemorySegment;

import static nowipi.rendering.OpenGL.*;

class HelloTriangle {

    private static final int SCR_WIDTH = 800;
    private static final int SCR_HEIGHT = 600;

    private static final String vertexShaderSource = "#version 330 core\nlayout (location = 0) in vec3 aPos;\nvoid main()\n{\n   gl_Position = vec4(aPos, 1.0);\n}";
    private static final String fragmentShaderSource = "#version 330 core\nout vec4 FragColor;\nvoid main()\n{\n   FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n}";

    public static void main(String[] args) {

        Window window = new Win32Window("Hello, Window!", SCR_WIDTH, SCR_HEIGHT);

        GraphicsContext<GDIDrawingSurface> gc = new WGLGraphicsContext((GDIDrawingSurface) window.getDrawingSurface());
        gc.makeCurrent();

        int vertexShader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShader, vertexShaderSource);
        glCompileShader(vertexShader);
        if (!glGetShaderCompileStatus(vertexShader)) {
            String infoLog = glGetShaderInfoLog(vertexShader, 512);
            throw new RuntimeException("ERROR::SHADER::VERTEX::COMPILATION_FAILED\n" + infoLog);
        }

        int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShader, fragmentShaderSource);
        glCompileShader(fragmentShader);
        if (!glGetShaderCompileStatus(fragmentShader)) {
            throw new RuntimeException("ERROR::SHADER::FRAGMENT::COMPILATION_FAILED\n" + glGetShaderInfoLog(fragmentShader, 512));
        }

        int shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);
        glLinkProgram(shaderProgram);
        if (!glGetProgramLinkStatus(shaderProgram)) {
            throw new RuntimeException("ERROR::SHADER::PROGRAM::LINKING_FAILED\n" + glGetProgramInfoLog(shaderProgram, 512));
        }
        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);


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
        int VAO = glGenVertexArrays();
        int VBO = glGenBuffers();
        int EBO = glGenBuffers();

        glBindVertexArray(VAO);

        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * Float.BYTES, MemorySegment.NULL);
        OpenGL.glEnableVertexAttribArray(0);


        glBindBuffer(GL_ARRAY_BUFFER, 0);

        glBindVertexArray(0);

        window.show();

        while (!window.shouldClose()) {

            glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            glUseProgram(shaderProgram);
            glBindVertexArray(VAO);
            glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, MemorySegment.NULL);

            window.swapBuffers();
            window.pollEvents();
        }

        glDeleteVertexArrays(VAO);
        glDeleteBuffers(VBO);
        glDeleteBuffers(EBO);
        glDeleteProgram(shaderProgram);
        gc.dispose();
        window.dispose();
    }

}
