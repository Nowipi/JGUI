package nowipi.jgui.input.keyboard;

import nowipi.jgui.window.Window;
import nowipi.jgui.windows.input.Win32Keyboard;

final class KeyboardTest {
    public static void main(String[] args) {
        Win32Keyboard keyboard = new Win32Keyboard();

        keyboard.addListener(new KeyboardEventListener() {
            @Override
            public void press(Key key) {
                System.out.println(key.toString());
            }

            @Override
            public void release(Key key) {

            }
        });

        Window window = Window.createWindowed("keyboard test", 1080, 720);
        window.show();

        while (!window.shouldClose()) {
            window.pollEvents();
        }

        keyboard.close();
    }
}
