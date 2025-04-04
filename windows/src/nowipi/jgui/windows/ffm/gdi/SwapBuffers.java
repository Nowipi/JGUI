package nowipi.jgui.windows.ffm.gdi;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

final class SwapBuffers {

    public static final FunctionDescriptor descriptor;
    public static final MethodHandle handle;

    static {
        descriptor = FunctionDescriptor.of(C.INT,
                C.POINTER
        );

        MemorySegment address = GDI32.lookup.find("SwapBuffers").orElseThrow();
        handle = Linker.nativeLinker().downcallHandle(address, descriptor);
    }

    private SwapBuffers() {

    }
}
