package nowipi.jgui.opengl;

import java.lang.foreign.FunctionDescriptor;
import java.lang.invoke.MethodHandle;

public interface GraphicsContext {

    void dispose();
    void makeCurrent();

    MethodHandle getMethodHandle(String methodName, FunctionDescriptor descriptor);
}
