package nowipi.rendering;

import nowipi.ffm.win32.Win32;
import nowipi.ffm.win32.wgl.Opengl32;
import nowipi.windowing.OpenGLImplementation;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

final class Opengl32OpenGLImplementation implements OpenGLImplementation {

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
