package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.*;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class MSG {

    private static final GroupLayout layout = MemoryLayout.structLayout(
            C.POINTER.withName("hwnd"),
            C.INT.withName("message"),
            MemoryLayout.paddingLayout(4),
            C.LONG_LONG.withName("wParam"),
            C.LONG_LONG.withName("lParam"),
            C.LONG.withName("time"),
            MemoryLayout.structLayout(
                    C.LONG.withName("x"),
                    C.LONG.withName("y")
            ).withName("pt"),
            MemoryLayout.paddingLayout(4)
    ).withName("MSG");

    private MSG() {
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static MemorySegment hWnd(MemorySegment msg) {
        MemoryLayout.PathElement path = groupElement("hwnd");
        return msg.get((AddressLayout) layout.select(path), layout.byteOffset(path));
    }

    public static int message(MemorySegment msg) {
        MemoryLayout.PathElement path = groupElement("message");
        return msg.get((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path));
    }

    public static long wParam(MemorySegment msg) {
        MemoryLayout.PathElement path = groupElement("wParam");
        return msg.get((ValueLayout.OfLong) layout.select(path), layout.byteOffset(path));
    }

    public static long lParam(MemorySegment msg) {
        MemoryLayout.PathElement path = groupElement("lParam");
        return msg.get((ValueLayout.OfLong) layout.select(path), layout.byteOffset(path));
    }

    public static int time(MemorySegment msg) {
        MemoryLayout.PathElement path = groupElement("time");
        return msg.get((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path));
    }

}
