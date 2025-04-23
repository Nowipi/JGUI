package nowipi.jgui.windows.ffm.gdi;

import nowipi.jgui.windows.ffm.C;
import nowipi.jgui.windows.ffm.Win32;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.util.HashMap;
import java.util.Map;

public final class GDI32 {

    public static final int PFD_SUPPORT_OPENGL = 0x00000020;
    public static final int PFD_DRAW_TO_WINDOW = 0x00000004;
    public static final int PFD_DOUBLEBUFFER = 0x00000001;
    public static final byte PFD_TYPE_RGBA = 0;

    public static final SymbolLookup lookup;
    public static final int PFD_MAIN_PLANE = 0;

    private final static Map<String, MethodHandle> methodHandles;

    private GDI32() {
    }

    static {
        lookup = SymbolLookup.libraryLookup(System.mapLibraryName("gdi32"), Win32.arena);
        methodHandles = new HashMap<>();
    }

    private static final FunctionDescriptor choosePixelFormatDescriptor = FunctionDescriptor.of(C.INT, C.POINTER, C.POINTER);
    public static int choosePixelFormat(MemorySegment hDC, MemorySegment hRC) {
        try {
            return (int) getMethodHandle("ChoosePixelFormat", choosePixelFormatDescriptor).invokeExact(hDC, hRC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor setPixelFormatDescriptor = FunctionDescriptor.of(C.INT, C.POINTER, C.INT, C.POINTER);
    public static int setPixelFormat(MemorySegment hdc, int format, MemorySegment ppfd) {
        try {
            return (int) getMethodHandle("SetPixelFormat", setPixelFormatDescriptor).invokeExact(hdc, format, ppfd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor swapBuffersDescriptor = FunctionDescriptor.of(C.INT, C.POINTER);
    public static int swapBuffers(MemorySegment hDC) {
        try {
            return (int) getMethodHandle("SwapBuffers", swapBuffersDescriptor).invokeExact(hDC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static MethodHandle getMethodHandle(String name, FunctionDescriptor descriptor) {
        var handle = methodHandles.get(name);
        if (handle != null) {
            return handle;
        }

        MemorySegment address = GDI32.lookup.find(name).orElseThrow();
        handle = Linker.nativeLinker().downcallHandle(address, descriptor);
        methodHandles.put(name, handle);
        return handle;
    }

}
