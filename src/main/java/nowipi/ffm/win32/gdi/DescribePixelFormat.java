package nowipi.ffm.win32.gdi;

import nowipi.ffm.c.C;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

final class DescribePixelFormat {
    public static final FunctionDescriptor descriptor;
    public static final MethodHandle handle;

    static {
        descriptor = FunctionDescriptor.of(C.INT,
                C.POINTER,
                C.INT,
                C.INT,
                C.POINTER
        );

        MemorySegment address = GDI32.lookup.find("DescribePixelFormat").orElseThrow();
        handle = Linker.nativeLinker().downcallHandle(address, descriptor);
    }

    private DescribePixelFormat() {

    }
}
