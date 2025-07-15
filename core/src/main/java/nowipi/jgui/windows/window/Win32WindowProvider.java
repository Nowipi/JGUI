package nowipi.jgui.windows.window;

import nowipi.jgui.window.Window;
import nowipi.jgui.window.WindowProvider;
import nowipi.jgui.window.WindowedWindow;

import static nowipi.jgui.windows.ffm.user32.User32.WS_POPUP;

public final class Win32WindowProvider implements WindowProvider {


    private static final WindowClass WINDOW_CLASS = new WindowClass("JavaWindow");

    @Override
    public WindowedWindow createWindowed(String title, int width, int height) {
        return WINDOW_CLASS.createWindowedInstance(title, width, height);
    }

    @Override
    public Window createBorderless(String title, int width, int height) {
        return WINDOW_CLASS.createInstance("", width, height, WS_POPUP);
    }
}
