package nowipi.jgui.windows.ffm;

import nowipi.jgui.windows.ffm.gdi.GDI32;
import nowipi.jgui.windows.ffm.gdi.GDI32Impl;
import nowipi.jgui.windows.ffm.user32.User32;
import nowipi.jgui.windows.ffm.user32.User32Impl;

import java.lang.foreign.Arena;

public final class Win32 {

    public static final Arena arena = Arena.global();
    public static final User32 user32 = new User32Impl();
    public static final GDI32 gdi32 = new GDI32Impl();

    private Win32() {
    }

    public static int loWord(long param) {
        return (int) (param & 0xffff);
    }

    public static int hiWord(long param) {
        return (int) ((param >> 16) & 0xffff);
    }
}
