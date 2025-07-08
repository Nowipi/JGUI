package nowipi.jgui.window;

import nowipi.jgui.windows.window.Win32WindowProvider;
import nowipi.jgui.window.event.EventDispatcher;

public interface Window extends Disposable, EventDispatcher {

    void show();
    boolean shouldClose();
    void pollEvents();
    void swapBuffers();
    void setPixelFormat(PixelFormat format);
    String title();
    int width();
    int height();
    void setPosition(int x, int y);
    int x();
    int y();

    WindowProvider provider = new Win32WindowProvider();

    static WindowedWindow createWindowed(String title, int width, int height) {
        return provider.createWindowed(title, width, height);
    }

    static Window createBorderless(String title, int width, int height) {
        return provider.createBorderless(title, width, height);
    }
}
