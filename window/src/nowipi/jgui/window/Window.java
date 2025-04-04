package nowipi.jgui.window;

import nowipi.jgui.opengl.GraphicsContext;
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

    static Window create(String title, int width, int height) {
        for (WindowProvider provider : ServiceLoader.load(WindowProvider.class)) {
            return provider.create(title, width, height);
        }
        throw new ProviderNotFoundException("Did you include a platform specific module?");
    }
}
