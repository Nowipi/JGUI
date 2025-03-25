package nowipi.ffm.win32.wgl;

import nowipi.ffm.c.C;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.invoke.MethodHandle;

final class MakeCurrent {

    public static final FunctionDescriptor descriptor = FunctionDescriptor.of(C.INT,
            C.POINTER,
            C.POINTER
    );
    public static final MethodHandle handle = Linker.nativeLinker().downcallHandle(
            Opengl32.lookup.find("wglMakeCurrent").orElseThrow(),
            descriptor
    );

    private MakeCurrent() {
    }
}
