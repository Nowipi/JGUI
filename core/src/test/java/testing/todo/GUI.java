package testing.todo;


import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGLGraphicsContext;

final class GUI {

    public static void main(String[] args) {
        Window window = Window.createWindowed("Window title", 1080, 720);
        OpenGLGraphicsContext gc = OpenGL.createGraphicsContext(window);

        window.show();

        /*new Container(
                new Styling.Builder()
                        .backgroundColor(Color.RED)
                        .build(),
                new ContainerLayout.Builder()
                        .width(new Grow())
                        .build(),
                new Text("Hello World!"),
                new Text("")
        );*/

        while (!window.shouldClose()) {
            window.pollEvents();

            window.swapBuffers();
        }
    }
}
