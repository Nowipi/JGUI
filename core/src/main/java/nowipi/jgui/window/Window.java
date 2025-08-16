package nowipi.jgui.window;

import nowipi.jgui.Rectangle;
import nowipi.jgui.input.keyboard.KeyboardEventListener;
import nowipi.jgui.window.event.WindowEventListener;
import nowipi.jgui.windows.window.Win32WindowProvider;
import nowipi.jgui.window.event.WindowMouseListener;

public interface Window extends Disposable {

    void addListener(WindowEventListener listener);
    void addListener(WindowMouseListener listener);
    void addListener(KeyboardEventListener listener);

    void show();
    boolean shouldClose();
    void pollEvents();
    void swapBuffers();
    String title();
    void setTopLeft(int x, int y);
    Rectangle bounds();

    WindowProvider provider = new Win32WindowProvider();

    static WindowedWindow createWindowed(String title, int width, int height) {
        return provider.createWindowed(title, width, height);
    }

    static Window createBorderless(String title, int width, int height) {
        return provider.createBorderless(title, width, height);
    }
}
