package nowipi.ffm.win32.wgl;

import nowipi.ffm.c.C;
import nowipi.ffm.win32.Win32;
import nowipi.windowing.OpenGLImplementation;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

public final class Opengl32 {

    public static final SymbolLookup lookup = SymbolLookup.libraryLookup(System.mapLibraryName("opengl32"), Win32.arena);

    public static final int WGL_CONTEXT_MAJOR_VERSION_ARB = 0x2091;
    public static final int WGL_CONTEXT_MINOR_VERSION_ARB = 0x2092;
    public static final int WGL_CONTEXT_FLAGS_ARB = 0x2094;

    private static OpenGLImplementation implementation;
    public static void init(OpenGLImplementation implementation) {
        if (Opengl32.implementation != null)
            throw new IllegalStateException("Can't intialize OpenGL multiple times");

        Opengl32.implementation = implementation;
    }

    private static OpenGLImplementation getImplementation() {
        if (implementation == null) {
            throw new IllegalStateException("OpenGL implementation not initialized yet, did you create a context?");
        }
        return implementation;
    }

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

    public static MemorySegment wglCreateContextAttribsARB(MemorySegment hDC, MemorySegment hShareContext, int[] attribList) {
        try(var arena = Arena.ofConfined()) {
            return wglCreateContextAttribsARB(hDC, hShareContext, arena.allocateFrom(C.INT, attribList));
        }
    }

    public static final FunctionDescriptor wglCreateContextAttribsARBDescriptor = FunctionDescriptor.of(C.POINTER, C.POINTER, C.POINTER, C.POINTER);
    public static MemorySegment wglCreateContextAttribsARB(MemorySegment hDC, MemorySegment hShareContext, MemorySegment attribList) {
        try {
            return (MemorySegment) getImplementation().getMethodHandle("wglCreateContextAttribsARB", wglCreateContextAttribsARBDescriptor).invokeExact(hDC, hShareContext, attribList);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
