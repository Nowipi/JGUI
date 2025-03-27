package nowipi.windowing;

import java.lang.foreign.FunctionDescriptor;
import java.lang.invoke.MethodHandle;

public interface OpenGLImplementation {

    MethodHandle getMethodHandle(String methodName, FunctionDescriptor descriptor);
}
