package nowipi.jgui.windows.ffm.wgl;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.invoke.MethodHandle;

final class GetProcAddress {

    public static final FunctionDescriptor descriptor = FunctionDescriptor.of(C.POINTER,
            C.POINTER
    );
    public static final MethodHandle handle = Linker.nativeLinker().downcallHandle(
            Opengl32.lookup.find("wglGetProcAddress").orElseThrow(),
            descriptor
    );

    private GetProcAddress() {
    }

}
