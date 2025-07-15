package nowipi.jgui.windows.window;

import nowipi.jgui.window.WindowedWindow;

import java.lang.foreign.MemorySegment;

public final class WindowedWin32Window extends Win32Window implements WindowedWindow {

    public WindowedWin32Window(MemorySegment hWnd) {
        super(hWnd);
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
