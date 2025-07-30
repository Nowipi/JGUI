package nowipi.jgui.windows.ffm.user32;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;

public final class PAINTSTRUCT {

    private static final MemoryLayout layout = MemoryLayout.structLayout(
            ValueLayout.ADDRESS.withName("hdc"),
            ValueLayout.JAVA_INT.withName("fErase"),
            RECT.layout.withName("rcPaint"),
            ValueLayout.JAVA_INT.withName("fRestore"),
            ValueLayout.JAVA_INT.withName("fIncUpdate"),
            MemoryLayout.sequenceLayout(32, ValueLayout.JAVA_BYTE).withName("rgbReserved")
    ).withName("tagPAINTSTRUCT");

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    private PAINTSTRUCT() {
    }
}
