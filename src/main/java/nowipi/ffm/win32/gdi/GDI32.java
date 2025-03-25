package nowipi.ffm.win32.gdi;

import nowipi.ffm.win32.user32.User32;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

public class GDI32 {

    public static final int PFD_SUPPORT_OPENGL = 0x00000020;
    public static final int PFD_DRAW_TO_WINDOW = 0x00000004;
    public static final int PFD_DOUBLEBUFFER = 0x00000001;
    public static final byte PFD_TYPE_RGBA = 0;

    public static final SymbolLookup lookup;

    static {
        lookup = SymbolLookup.libraryLookup(System.mapLibraryName("gdi32"), User32.arena);
    }

    public static int choosePixelFormat(MemorySegment hDC, MemorySegment hRC) {
        try {
            return (int) ChoosePixelFormat.handle.invokeExact(hDC, hRC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int setPixelFormat(MemorySegment hdc, int format, MemorySegment ppfd) {
        try {
            return (int) SetPixelFormat.handle.invokeExact(hdc, format, ppfd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int describePixelFormat(MemorySegment hdc, int iPixelFormat, int nBytes, MemorySegment ppfd) {
        try {
            return (int) DescribePixelFormat.handle.invokeExact(hdc, iPixelFormat, nBytes, ppfd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int swapBuffers(MemorySegment hDC) {
        try {
            return (int) SwapBuffers.handle.invokeExact(hDC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
