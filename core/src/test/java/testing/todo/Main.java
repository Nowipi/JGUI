package testing.todo;

import nowipi.jgui.rendering.ComponentRenderer;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;

final class Main {
    public static void main(String[] args) {
        Window window = Window.createBorderless("Todo GUI", 1080, 720);
        OpenGLGraphicsContext gc = OpenGL.createGraphicsContext(window, 3, 2, OpenGL.Profile.CORE);

        Todo todo = new Todo();
        todo.items().addItem(new Item("Rendering"));

        TodoLook todoView = new TodoLook(todo);

        TodoInteraction todoInteraction = new TodoInteraction(todo);

        Rectangle windowBounds = window.bounds();
        ComponentRenderer renderer = new ComponentRenderer(Matrix4f.ortho(0, windowBounds.width(), windowBounds.height(), 0, -1, 1), gc);

        window.show();

        while (!window.shouldClose()) {
            window.pollEvents();

            gc.glClear(OpenGL.GL_COLOR_BUFFER_BIT | OpenGL.GL_DEPTH_BUFFER_BIT);
            gc.glClearColor(1, 0, 1, 1);

            renderer.beginFrame();
            renderer.drawComponent(todoView);
            renderer.endFrame();

            window.swapBuffers();
        }
    }
}
