package nowipi.jgui.windows.window;

import nowipi.jgui.window.Window;
import nowipi.jgui.window.WindowProvider;
import nowipi.jgui.window.WindowedWindow;

public final class Win32WindowProvider implements WindowProvider {
    @Override
    public WindowedWindow createWindowed(String title, int width, int height) {
        return new WindowedWin32Window(title, width, height);
    }

    @Override
    public Window createBorderless(String title, int width, int height) {
        return new Win32Window(title, width, height);
    }
}
