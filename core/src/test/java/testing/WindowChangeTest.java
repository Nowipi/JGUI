package testing;

import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.primitives.Rectangle;

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

        Rectangle firstBounds = firstWindow.bounds();
        Window secondWindow = Window.createBorderless(firstWindow.title(), (int) firstBounds.width(), (int) firstBounds.height());
        secondWindow.setTopLeft((int) firstBounds.topLeft.x, (int) firstBounds.topLeft.y);


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
