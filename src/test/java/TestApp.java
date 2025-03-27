import nowipi.rendering.GraphicsContext;
import nowipi.windowing.*;
import nowipi.rendering.WGLGraphicsContext;
import nowipi.windowing.win32.GDIDrawingSurface;
import nowipi.windowing.win32.Win32Window;

import static nowipi.rendering.OpenGL.*;

class TestApp {

    public static void main(String[] args) {
        Window window = new Win32Window("Hello, Window!", 1080, 650);

        DrawingSurface surface = window.getDrawingSurface();
        GraphicsContext<?> gc = new WGLGraphicsContext((GDIDrawingSurface) surface);
        gc.makeCurrent();

        window.show();

        while (!window.shouldClose()) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(1, 1, 0, 1);

            window.swapBuffers();

            window.pollEvents();
        }
        gc.dispose();
        window.dispose();
    }

}
