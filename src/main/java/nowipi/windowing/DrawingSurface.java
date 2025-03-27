package nowipi.windowing;

public interface DrawingSurface extends Disposable {
    void setPixelFormat(PixelFormat format);
    void swapBuffers();
}
