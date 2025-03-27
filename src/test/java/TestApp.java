import nowipi.windowing.*;
import nowipi.windowing.win32.WGLGraphicsContext;
import nowipi.windowing.win32.Win32DrawingSurface;
import nowipi.windowing.win32.Win32Window;

import static nowipi.windowing.OpenGL.*;

class TestApp {

    public static void main(String[] args) {
        Window window = new Win32Window("Hello, Window!", 1080, 650);

        DrawingSurface surface = window.getDrawingSurface();
        GraphicsContext<Win32DrawingSurface> gc = new WGLGraphicsContext((Win32DrawingSurface) surface);
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
