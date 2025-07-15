package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.*;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class RECT {

    public static final MemoryLayout layout = MemoryLayout.structLayout(
            C.INT.withName("left"),
            C.INT.withName("top"),
            C.INT.withName("right"),
            C.INT.withName("bottom")
    ).withName("tagRECT");

    private RECT() {
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static int left(MemorySegment rect) {
        MemoryLayout.PathElement path = groupElement("left");
        return rect.get((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path));
    }

    public static int top(MemorySegment rect) {
        MemoryLayout.PathElement path = groupElement("top");
        return rect.get((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path));
    }

    public static int right(MemorySegment rect) {
        MemoryLayout.PathElement path = groupElement("right");
        return rect.get((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path));
    }

    public static int bottom(MemorySegment rect) {
        MemoryLayout.PathElement path = groupElement("bottom");
        return rect.get((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path));
    }
}
