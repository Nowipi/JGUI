import nowipi.windowing.Window;
import nowipi.windowing.Win32Window;

class TestApp {

    public static void main(String[] args) {
        Window window = new Win32Window("Hello, Window!", 1080, 650);
        /*
        Software rendering and GPU rendering
        Win32:
            - GDI
            - OpenGL
        */

        while (!window.shouldClose()) {
            window.pollEvents();
        }
    }

}
