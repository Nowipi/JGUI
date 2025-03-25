package nowipi.ffm.win32.user32;

import nowipi.ffm.c.C;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

final class RegisterClassW {

    public static final FunctionDescriptor descriptor;
    public static final MethodHandle handle;

    static {
        descriptor = FunctionDescriptor.of(C.SHORT,
                C.POINTER
        );
        MemorySegment address = User32.lookup.find("RegisterClassW").orElseThrow();
        handle =  Linker.nativeLinker().downcallHandle(address, descriptor);
    }

    private RegisterClassW() {}

}
