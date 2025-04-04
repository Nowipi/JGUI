package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

final class GetDC {
    public static final FunctionDescriptor descriptor;
    public static final MethodHandle handle;

    static {
        descriptor = FunctionDescriptor.of(C.POINTER,
                C.POINTER
        );

        MemorySegment address = User32.lookup.find("GetDC").orElseThrow();
        handle = Linker.nativeLinker().downcallHandle(address, descriptor);
    }

    private GetDC() {

    }
}
