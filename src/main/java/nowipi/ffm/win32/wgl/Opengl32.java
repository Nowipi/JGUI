package nowipi.ffm.win32.wgl;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

import static nowipi.ffm.win32.user32.User32.arena;

public final class Opengl32 {

    public static final SymbolLookup lookup = SymbolLookup.libraryLookup(System.mapLibraryName("opengl32"), arena);

    public static MemorySegment wglCreateContext(MemorySegment hDC) {
        try {
            return (MemorySegment) CreateContext.handle.invokeExact(hDC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int wglMakeCurrent(MemorySegment hDC, MemorySegment hRC) {
        try {
            return (int) MakeCurrent.handle.invokeExact(hDC, hRC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MemorySegment wglGetProcAddress(MemorySegment unnamedParam1) {
        try {
            return (MemorySegment) GetProcAddress.handle.invokeExact(unnamedParam1);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int wglDeleteContext(MemorySegment unnamedParam1) {
        try {
            return (int) DeleteContext.handle.invokeExact(unnamedParam1);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private Opengl32() {
    }
}
