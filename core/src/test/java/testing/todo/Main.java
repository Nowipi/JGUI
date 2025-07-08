package testing.todo;

import nowipi.jgui.components.Component;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;

final class Main {
    public static void main(String[] args) {
        Window window = Window.createWindowed("Todo GUI", 1080, 720);
        OpenGLGraphicsContext context = OpenGL.createGraphicsContext(window);

        TodoGUI gui = new TodoGUI();
        gui.layout.layout(gui);
        ComponentRenderer renderer = new ComponentRenderer(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1), context);

        window.show();

        while (!window.shouldClose()) {
            window.pollEvents();

            //renderer.renderComponent(gui);

            window.swapBuffers();
        }
    }

    private void renderComponent(Component component) {

    }
}
