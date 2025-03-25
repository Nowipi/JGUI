package nowipi.windowing;

public abstract class Window implements AutoCloseable {

    public Window(String title, int width, int height) {}

    public abstract boolean shouldClose();
    public abstract void pollEvents();
    public abstract void swapBuffers();

    @Override
    public void close() {}
}
