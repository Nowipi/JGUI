package nowipi.ffm.win32.wgl;

import nowipi.windowing.OpenGLImplementation;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static nowipi.ffm.win32.user32.User32.arena;

public final class Opengl32 implements OpenGLImplementation {

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

    //From: https://github.com/FDoKE/opengl-ffm/blob/master/src/main/java/ru/fdoke/ffm/opengl/api/opengl/OpenglApi.java
    private static final Map<String, MethodHandle> methodHandles = new HashMap<>();

    @Override
    public MethodHandle getMethodHandle(String methodName, FunctionDescriptor descriptor) {
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
        MemorySegment extensionMethodNameMemorySegment = arena.allocateFrom(methodName);
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
