import nowipi.windowing.Window;
import nowipi.windowing.Win32Window;

import static nowipi.ffm.opengl.OpenGL.*;

class TestApp {

    public static void main(String[] args) {
        Window window = new Win32Window("Hello, Window!", 1080, 650);

        while (!window.shouldClose()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(1, 1, 1, 1);

            window.swapBuffers();

            window.pollEvents();
        }
        window.close();
    }

}
