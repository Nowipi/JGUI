package nowipi.jgui.windows.window;

import nowipi.jgui.window.WindowedWindow;
import nowipi.jgui.windows.ffm.user32.User32;

import java.lang.foreign.MemorySegment;

import static nowipi.jgui.windows.ffm.Win32.user32;
import static nowipi.jgui.windows.ffm.user32.User32.SWP_NOMOVE;
import static nowipi.jgui.windows.ffm.user32.User32.SWP_NOZORDER;

public final class WindowedWin32Window extends Win32Window implements WindowedWindow {

    private final MemorySegment hWnd;

    public WindowedWin32Window(MemorySegment hWnd) {
        super(hWnd);
        this.hWnd = hWnd;
    }

    @Override
    public void maximize() {
        user32.showWindow(hWnd, User32.SW_MAXIMIZE);
    }

    @Override
    public void minimize() {
        user32.showWindow(hWnd, User32.SW_MINIMIZE);
    }

    @Override
    public void restore() {
        user32.showWindow(hWnd, User32.SW_RESTORE);
    }

    @Override
    public void resize(int width, int height) {
        user32.setWindowPos(hWnd, MemorySegment.NULL, 0, 0, width, height, SWP_NOMOVE | SWP_NOZORDER);
    }
}
