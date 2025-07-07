package testing;

import nowipi.jgui.window.Window;

import static nowipi.opengl.OpenGL.*;

final class WindowChangeTest {

    public static void main(String[] args) {
        Window firstWindow = Window.createWindowed("Bruh", 1080 , 720);

        var gc = firstWindow.createGraphicsContext();

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

        gc = secondWindow.createGraphicsContext();
        secondWindow.show();

        while (!secondWindow.shouldClose()) {
            secondWindow.pollEvents();

            gc.glClear(GL_COLOR_BUFFER_BIT);
            gc.glClearColor(1, 1, 1, 1);
            secondWindow.swapBuffers();
        }
    }

}
