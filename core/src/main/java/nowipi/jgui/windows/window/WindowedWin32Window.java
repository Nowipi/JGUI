package nowipi.jgui.windows.window;

import nowipi.jgui.window.WindowedWindow;

import java.lang.foreign.MemorySegment;

public final class WindowedWin32Window extends Win32Window implements WindowedWindow {

    public WindowedWin32Window(MemorySegment hWnd) {
        super(hWnd);
    }

    @Override
    public void maximize() {
        //TODO implementation
    }

    @Override
    public void minimize() {
        //TODO implementation
    }

    @Override
    public void restore() {
        //TODO implementation
    }

    @Override
    public void resize(int width, int height) {
        //TODO implementation
    }

    @Override
    public void setWidth(int width) {
        //TODO implementation
    }

    @Override
    public void setHeight(int height) {
        //TODO implementation
    }
}
