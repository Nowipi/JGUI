package testing;

import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.jgui.window.event.WindowResizeEvent;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static nowipi.opengl.OpenGL.*;

class HelloTriangle {

    private static final int SCR_WIDTH = 800;
    private static final int SCR_HEIGHT = 600;

    private static final String vertexShaderSource = "#version 330 core\nlayout (location = 0) in vec3 aPos;\nvoid main()\n{\n   gl_Position = vec4(aPos, 1.0);\n}";
    private static final String fragmentShaderSource = "#version 330 core\nout vec4 FragColor;\nvoid main()\n{\n   FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n}";

    public static void main(String[] args) {

        Window window = Window.createWindowed("Hello, Window!", SCR_WIDTH, SCR_HEIGHT);

        GraphicsContext gc = window.createGraphicsContext();

        window.addListener(WindowResizeEvent.class, e -> gc.glViewport(0, 0, e.width(), e.height()));


        int vertexShader = gc.glCreateShader(GL_VERTEX_SHADER);


        try (var arena = Arena.ofConfined()) {
            gc.glShaderSource(vertexShader, 1, arena.allocateFrom(ValueLayout.ADDRESS, arena.allocateFrom(vertexShaderSource)), arena.allocateFrom(ValueLayout.JAVA_INT,
                    vertexShaderSource.length()));
            gc.glCompileShader(vertexShader);
        /*if (!gc.glGetShaderCompileStatus(vertexShader)) {
            String infoLog = gc.glGetShaderInfoLog(vertexShader, 512);
            throw new RuntimeException("ERROR::SHADER::VERTEX::COMPILATION_FAILED\n" + infoLog);
        }*/

            int fragmentShader = gc.glCreateShader(GL_FRAGMENT_SHADER);
            gc.glShaderSource(fragmentShader, 1, arena.allocateFrom(ValueLayout.ADDRESS, arena.allocateFrom(fragmentShaderSource)), arena.allocateFrom(ValueLayout.JAVA_INT,
                    fragmentShaderSource.length()));
            gc.glCompileShader(fragmentShader);
        /*if (!gc.glGetShaderCompileStatus(fragmentShader)) {
            throw new RuntimeException("ERROR::SHADER::FRAGMENT::COMPILATION_FAILED\n" + gc.glGetShaderInfoLog(fragmentShader, 512));
        }*/

            int shaderProgram = gc.glCreateProgram();
            gc.glAttachShader(shaderProgram, vertexShader);
            gc.glAttachShader(shaderProgram, fragmentShader);
            gc.glLinkProgram(shaderProgram);
        /*if (!gc.glGetProgramLinkStatus(shaderProgram)) {
            throw new RuntimeException("ERROR::SHADER::PROGRAM::LINKING_FAILED\n" + gc.glGetProgramInfoLog(shaderProgram, 512));
        }*/
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
            MemorySegment VAOP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGenVertexArrays(1, VAOP);
            int VAO = VAOP.get(ValueLayout.JAVA_INT, 0);

            MemorySegment VBOP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGenBuffers(1, VBOP);
            int VBO = VBOP.get(ValueLayout.JAVA_INT, 0);

            MemorySegment EBOP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGenBuffers(1, EBOP);
            int EBO = EBOP.get(ValueLayout.JAVA_INT, 0);

            gc.glBindVertexArray(VAO);

            gc.glBindBuffer(GL_ARRAY_BUFFER, VBO);
            gc.glBufferData(GL_ARRAY_BUFFER, vertices.length * Float.BYTES, arena.allocateFrom(ValueLayout.JAVA_FLOAT, vertices), GL_STATIC_DRAW);

            gc.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
            gc.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * Integer.BYTES, arena.allocateFrom(ValueLayout.JAVA_INT, indices), GL_STATIC_DRAW);

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

            gc.glDeleteVertexArrays(1, arena.allocateFrom(ValueLayout.JAVA_INT, VAO));
            gc.glDeleteBuffers(1, arena.allocateFrom(ValueLayout.JAVA_INT, VBO));
            gc.glDeleteBuffers(1, arena.allocateFrom(ValueLayout.JAVA_INT, EBO));
            gc.glDeleteProgram(shaderProgram);
            gc.dispose();
            window.dispose();
        }

    }

}
