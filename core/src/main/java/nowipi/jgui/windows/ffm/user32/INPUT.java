package nowipi.jgui.windows.ffm.user32;

import java.lang.foreign.*;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class INPUT {

    private static final GroupLayout layout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("type"),
            MemoryLayout.paddingLayout(4),
            MemoryLayout.unionLayout(
                    MOUSEINPUT.layout.withName("mi")//,
                    //KEYBDINPUT.layout.withName("ki"),
                    //HARDWAREINPUT.layout.withName("hi")
            ).withName("DUMMYUNIONNAME")
    ).withName("INPUT");

    public static final long BYTES = layout.byteSize();

    private INPUT() {
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static void setType(MemorySegment input, int type) {
        input.set((ValueLayout.OfInt) layout.select(groupElement("type")), 0, type);
    }
    public static MemorySegment mi(MemorySegment input) {
        return input.asSlice(layout.byteOffset(groupElement("DUMMYUNIONNAME"), groupElement("mi")), MOUSEINPUT.layout.byteSize());
    }
}
