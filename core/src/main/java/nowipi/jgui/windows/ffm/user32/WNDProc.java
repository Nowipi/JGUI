package nowipi.jgui.windows.ffm.user32;

import java.lang.foreign.MemorySegment;

@FunctionalInterface
public interface WNDProc {
    long windowProc(MemorySegment hwnd, int uMsg, long wParam, long lParam);
}
