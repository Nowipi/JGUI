package testing;

import nowipi.jgui.window.Window;

final class WindowTest {
    public static void main(String[] args) {
        Window window = Window.createWindowed("Hi", 1080, 720);

        window.show();

        while (!window.shouldClose()) {
            window.pollEvents();
        }
    }
}
