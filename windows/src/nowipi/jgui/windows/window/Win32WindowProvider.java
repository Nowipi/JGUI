package nowipi.jgui.windows.window;

import nowipi.jgui.window.Window;
import nowipi.jgui.window.WindowProvider;

public final class Win32WindowProvider implements WindowProvider {
    @Override
    public Window create(String title, int width, int height) {
        return new Win32Window(title, width, height);
    }
}
