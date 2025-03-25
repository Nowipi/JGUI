package nowipi.windowing;

public abstract class Window {

    public Window(String title, int width, int height) {}

    public abstract boolean shouldClose();
    public abstract void pollEvents();

}
