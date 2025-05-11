package testing.todo;

import nowipi.jgui.components.Container;
import nowipi.jgui.components.Text;
import nowipi.jgui.components.styling.Color;
import nowipi.jgui.components.styling.ContainerLayout;
import nowipi.jgui.components.styling.Grow;
import nowipi.jgui.components.styling.Styling;
import nowipi.jgui.window.Window;
import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGL;

final class GUI {

    public static void main(String[] args) {
        Window window = Window.create("Window title", 1080, 720);
        GraphicsContext gc = window.createGraphicsContext();
        gc.makeCurrent();

        OpenGL.init(gc);

        window.show();

        new Container(
                new Styling.Builder()
                        .backgroundColor(Color.RED)
                        .build(),
                new ContainerLayout.Builder()
                        .width(new Grow())
                        .build(),
                new Text("Hello World!"),
                new Text("")
        );

        while (!window.shouldClose()) {
            window.pollEvents();

            window.swapBuffers();
        }
    }
}
