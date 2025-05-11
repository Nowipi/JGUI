package testing;

import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGL;

import static nowipi.opengl.OpenGL.*;

final class WindowChangeTest {

    public static void main(String[] args) {
        Window firstWindow = Window.createWindowed("Bruh", 1080 , 720);

        var gc = firstWindow.createGraphicsContext();
        gc.makeCurrent();
        OpenGL.init(gc);

        firstWindow.show();

        while (!firstWindow.shouldClose()) {
            firstWindow.pollEvents();

            glClear(GL_COLOR_BUFFER_BIT);
            glClearColor(1, 1, 1, 1);
            firstWindow.swapBuffers();
        }

        gc.dispose();

        Window secondWindow = Window.createBorderless(firstWindow.title(), firstWindow.width(), firstWindow.height());
        secondWindow.setPosition(firstWindow.x(), firstWindow.y());

        firstWindow.close();

        gc = secondWindow.createGraphicsContext();
        gc.makeCurrent();
        OpenGL.init(gc);
        secondWindow.show();

        while (!secondWindow.shouldClose()) {
            secondWindow.pollEvents();

            glClear(GL_COLOR_BUFFER_BIT);
            glClearColor(1, 1, 1, 1);
            secondWindow.swapBuffers();
        }
    }

}
