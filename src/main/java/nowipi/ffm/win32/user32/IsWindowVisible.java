package nowipi.ffm.win32.user32;

import nowipi.ffm.c.C;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

final class IsWindowVisible {

    public static final FunctionDescriptor descriptor;
    public static final MethodHandle handle;

    static {
        descriptor = FunctionDescriptor.of(C.BOOL,
                C.POINTER
        );

        MemorySegment address = User32.lookup.find("IsWindowVisible").orElseThrow();
        handle = Linker.nativeLinker().downcallHandle(address, descriptor);
    }

    private IsWindowVisible() {
    }
}
