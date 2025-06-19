package nowipi.jgui.windows.window;

import nowipi.jgui.window.WindowedWindow;
import nowipi.jgui.windows.ffm.user32.User32;

final class WindowedWin32Window extends Win32Window implements WindowedWindow {

    public WindowedWin32Window(String title, int width, int height) {
        super(title, width, height, User32.WS_OVERLAPPEDWINDOW);
    }

    @Override
    public void maximize() {

    }

    @Override
    public void minimize() {

    }

    @Override
    public void restore() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }
}
