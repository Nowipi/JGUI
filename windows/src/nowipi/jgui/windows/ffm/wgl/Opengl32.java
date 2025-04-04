package nowipi.jgui.windows.ffm.wgl;

import nowipi.jgui.windows.ffm.C;
import nowipi.jgui.windows.ffm.Win32;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Opengl32 {

    public static final SymbolLookup lookup = SymbolLookup.libraryLookup(System.mapLibraryName("opengl32"), Win32.arena);

    public static final int WGL_CONTEXT_MAJOR_VERSION_ARB = 0x2091;
    public static final int WGL_CONTEXT_MINOR_VERSION_ARB = 0x2092;
    public static final int WGL_CONTEXT_FLAGS_ARB = 0x2094;

    private static final Map<String, MethodHandle> methodHandles = new HashMap<>();


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
            return (MemorySegment) getMethodHandle("wglCreateContextAttribsARB", wglCreateContextAttribsARBDescriptor).invokeExact(hDC, hShareContext, attribList);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MethodHandle getMethodHandle(String methodName, FunctionDescriptor descriptor) {
        MethodHandle cachedHandle = methodHandles.get(methodName);
        if (cachedHandle != null) {
            return cachedHandle;
        }

        // trying to find method handle by loaderLookup
        Optional<MemorySegment> directMethodAddress = Opengl32.lookup.find(methodName);
        if (directMethodAddress.isPresent()) {
            MethodHandle methodHandle = Linker.nativeLinker().downcallHandle(directMethodAddress.get(), descriptor);
            methodHandles.put(methodName, methodHandle);
            return methodHandle;
        }

        // Some opengl functions are not in lookup table (extensions) so we need to call wglGetProcAddress to get pointer to needed function
        MemorySegment extensionMethodNameMemorySegment = Win32.arena.allocateFrom(methodName);
        MemorySegment address = Opengl32.wglGetProcAddress(extensionMethodNameMemorySegment);

        if (address.equals(MemorySegment.NULL)) {
            throw new IllegalArgumentException("Could not find method: " + methodName);
        }


        // making call to retrieved function address
        MemorySegment methodAddress = MemorySegment.ofAddress(address.address());
        MethodHandle methodHandle = Linker.nativeLinker().downcallHandle(methodAddress, descriptor);
        methodHandles.put(methodName, methodHandle);
        return methodHandle;
    }

}
