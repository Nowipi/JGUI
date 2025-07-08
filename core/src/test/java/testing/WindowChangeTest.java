package testing;

import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;

import static nowipi.opengl.OpenGL.*;

final class WindowChangeTest {

    public static void main(String[] args) {
        Window firstWindow = Window.createWindowed("Bruh", 1080 , 720);

        var gc = OpenGL.createGraphicsContext(firstWindow);

        firstWindow.show();

        while (!firstWindow.shouldClose()) {
            firstWindow.pollEvents();

            gc.glClear(GL_COLOR_BUFFER_BIT);
            gc.glClearColor(1, 1, 1, 1);
            firstWindow.swapBuffers();
        }

        gc.dispose();

        Window secondWindow = Window.createBorderless(firstWindow.title(), firstWindow.width(), firstWindow.height());
        secondWindow.setPosition(firstWindow.x(), firstWindow.y());

        firstWindow.close();

        gc = OpenGL.createGraphicsContext(secondWindow);
        secondWindow.show();

        while (!secondWindow.shouldClose()) {
            secondWindow.pollEvents();

            gc.glClear(GL_COLOR_BUFFER_BIT);
            gc.glClearColor(1, 1, 1, 1);
            secondWindow.swapBuffers();
        }
    }

}
