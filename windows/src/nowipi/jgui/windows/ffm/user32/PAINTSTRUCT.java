package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

public final class PAINTSTRUCT {

    private static final MemoryLayout layout = MemoryLayout.structLayout(
            C.POINTER.withName("hdc"),
            C.INT.withName("fErase"),
            MemoryLayout.structLayout(
                    C.LONG.withName("left"),
                    C.LONG.withName("top"),
                    C.LONG.withName("right"),
                    C.LONG.withName("bottom")
            ).withName("rcPaint"),
            C.INT.withName("fRestore"),
            C.INT.withName("fIncUpdate"),
            MemoryLayout.sequenceLayout(32, C.CHAR).withName("rgbReserved"),
            MemoryLayout.paddingLayout(4)
    ).withName("tagPAINTSTRUCT");

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    private PAINTSTRUCT() {
    }
}
