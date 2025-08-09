package testing.todo;

import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;

final class Main {
    public static void main(String[] args) {
        Window window = Window.createWindowed("Todo GUI", 1080, 720);
        OpenGLGraphicsContext gc = OpenGL.createGraphicsContext(window, 3, 2, OpenGL.Profile.CORE);

        Todo todo = new Todo();
        todo.addItem("Rendering");

        Rectangle windowBounds = window.bounds();
        ComponentRenderer renderer = new ComponentRenderer(calculateProjectionMatrix((int) windowBounds.width(), (int) windowBounds.height()), gc);

        window.addListener((width, height) -> {
            gc.glViewport(0, 0, width, height);
            renderer.setProjectionMatrix(calculateProjectionMatrix(width, height));

        });
        window.addListener(todo.mouseInteractionListener());

        window.show();


        while (!window.shouldClose()) {
            window.pollEvents();

            gc.glClear(OpenGL.GL_COLOR_BUFFER_BIT | OpenGL.GL_DEPTH_BUFFER_BIT);
            gc.glClearColor(1, 0, 1, 1);

            renderer.startFrame();
            todo.draw(renderer);
            renderer.endFrame();

            window.swapBuffers();
        }
    }

    private static Matrix4f calculateProjectionMatrix(int width, int height) {
        return Matrix4f.ortho(0, width, 0, height, -1, 1);
    }
}
