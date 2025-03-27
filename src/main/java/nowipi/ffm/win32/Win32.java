package nowipi.ffm.win32;

import java.lang.foreign.Arena;

public final class Win32 {

    public static final Arena arena = Arena.global();

    private Win32() {
    }

    public static int loWord(long param) {
        return (int) (param & 0xffff);
    }

    public static int hiWord(long param) {
        return (int) ((param >> 16) & 0xffff);
    }
}
