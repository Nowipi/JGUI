package nowipi.windowing;

public interface Window extends Disposable {

    void show();
    boolean shouldClose();
    void pollEvents();
    void swapBuffers();
    DrawingSurface getDrawingSurface();
}
