package nowipi.jgui.window;

public interface WindowProvider {
    WindowedWindow createWindowed(String title, int width, int height);
    Window createBorderless(String title, int width, int height);
}
