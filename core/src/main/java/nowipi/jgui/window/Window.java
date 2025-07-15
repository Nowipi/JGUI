package nowipi.jgui.window;

import nowipi.jgui.window.event.WindowEventListener;
import nowipi.jgui.windows.window.Win32WindowProvider;
import nowipi.jgui.event.EventDispatcher;
import nowipi.primitives.Rectangle;

public interface Window extends Disposable, EventDispatcher<WindowEventListener> {

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
