import nowipi.jgui.window.WindowProvider;
import nowipi.jgui.windows.window.Win32WindowProvider;

module jgui.windows {

    requires jgui.window;
    requires static jgui.opengl;
    provides WindowProvider with Win32WindowProvider;
}