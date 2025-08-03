package nowipi.jgui.window;

public interface WindowedWindow extends Window {

    void maximize();
    void minimize();
    void restore();
    void resize(int width, int height);

}
