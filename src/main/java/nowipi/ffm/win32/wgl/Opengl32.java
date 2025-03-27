package nowipi.ffm.win32.wgl;

import nowipi.ffm.win32.Win32;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

public final class Opengl32 {

    public static final SymbolLookup lookup = SymbolLookup.libraryLookup(System.mapLibraryName("opengl32"), Win32.arena);

    private Opengl32() {
    }

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

}
