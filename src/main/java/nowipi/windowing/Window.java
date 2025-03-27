package nowipi.windowing;

import nowipi.event.EventDispatcher;

public interface Window extends Disposable, EventDispatcher {

    void show();
    boolean shouldClose();
    void pollEvents();
    void swapBuffers();
    DrawingSurface getDrawingSurface();
}
