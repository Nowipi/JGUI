package testing.todo;

import nowipi.jgui.components.Component;
import nowipi.jgui.window.Window;
import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGL;
import nowipi.primitives.Matrix4f;

final class Main {
    public static void main(String[] args) {
        Window window = Window.create("Todo GUI", 1080, 720);
        GraphicsContext context = window.createGraphicsContext();
        context.makeCurrent();
        OpenGL.init(context);

        TodoGUI gui = new TodoGUI();
        gui.layout.layout(gui);
        ComponentRenderer renderer = new ComponentRenderer(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1));

        window.show();

        while (!window.shouldClose()) {
            window.pollEvents();

            renderer.renderComponent(gui);

            window.swapBuffers();
        }
    }

    private void renderComponent(Component component) {

    }
}
