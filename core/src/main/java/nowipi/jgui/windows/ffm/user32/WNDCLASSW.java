package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;
import nowipi.jgui.windows.ffm.Win32;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class WNDCLASSW {
    private static final MemoryLayout layout = MemoryLayout.structLayout(
            C.INT.withName("style"),
            MemoryLayout.paddingLayout(4),
            C.POINTER.withName("lpfnWndProc"),
            C.INT.withName("cbClsExtra"),
            C.INT.withName("cbWndExtra"),
            C.POINTER.withName("hInstance"),
            C.POINTER.withName("hIcon"),
            C.POINTER.withName("hCursor"),
            C.POINTER.withName("hbrBackground"),
            C.POINTER.withName("lpszMenuName"),
            C.POINTER.withName("lpszClassName")
    ).withName("tagWNDCLASSW");

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static void setStyle(MemorySegment wndClass, int style) {
        MemoryLayout.PathElement path = groupElement("style");
        wndClass.set(C.INT, layout.byteOffset(path), style);
    }

    public static void setLpszClassName(MemorySegment wndClass, MemorySegment wndClassName) {
        MemoryLayout.PathElement path = groupElement("lpszClassName");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), wndClassName);
    }

    public static void setLpfnWndProc(MemorySegment wndClass, WNDProc proc) {
        MemoryLayout.PathElement path = groupElement("lpfnWndProc");
        try {
            MethodHandle hWndProc = MethodHandles.lookup().findVirtual(WNDProc.class, "windowProc",
                    MethodType.methodType(long.class,
                            MemorySegment.class,
                            int.class,
                            long.class,
                            long.class
                    )).bindTo(proc);

            FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);
            wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), Linker.nativeLinker().upcallStub(hWndProc, descriptor, Win32.arena));
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sethCursor(MemorySegment wndClass, MemorySegment hCursor) {
        MemoryLayout.PathElement path = groupElement("hCursor");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), hCursor);
    }

    private WNDCLASSW() {
    }
}
