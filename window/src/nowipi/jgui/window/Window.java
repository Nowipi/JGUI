package nowipi.jgui.window;

import nowipi.opengl.GraphicsContext;
import nowipi.jgui.window.event.EventDispatcher;

import java.nio.file.ProviderNotFoundException;
import java.util.ServiceLoader;

public interface Window extends Disposable, EventDispatcher {

    void show();
    boolean shouldClose();
    void pollEvents();
    void swapBuffers();
    GraphicsContext createGraphicsContext();
    void setPixelFormat(PixelFormat format);
    String title();
    int width();
    int height();
    void setPosition(int x, int y);
    int x();
    int y();

    WindowProvider provider = ServiceLoader.load(WindowProvider.class).findFirst().orElseThrow(() -> new ProviderNotFoundException("Did you include a platform specific module?"));

    static WindowedWindow createWindowed(String title, int width, int height) {
        return provider.createWindowed(title, width, height);
    }

    static Window createBorderless(String title, int width, int height) {
        return provider.createBorderless(title, width, height);
    }
}
