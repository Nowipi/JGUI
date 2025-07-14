package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.Win32;

import java.lang.foreign.*;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class MSLLHOOKSTRUCT {

    private static final MemoryLayout layout = MemoryLayout.structLayout(
            MemoryLayout.structLayout(
                    ValueLayout.JAVA_INT.withName("x"),
                    ValueLayout.JAVA_INT.withName("y")
            ).withName("pt"),
            ValueLayout.JAVA_INT.withName("mouseData"),
            ValueLayout.JAVA_INT.withName("flags"),
            ValueLayout.JAVA_INT.withName("time"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS.withName("dwExtraInfo")
    ).withName("tagMSLLHOOKSTRUCT");

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static MemorySegment ofAddress(long address) {
        return MemorySegment.ofAddress(address).reinterpret(layout.byteSize(), Win32.arena, null);
    }

    public static int mouseData(MemorySegment struct) {
        return struct.get(ValueLayout.JAVA_INT, layout.byteOffset(groupElement("mouseData")));
    }

    public static int x(MemorySegment struct) {
        return struct.get(ValueLayout.JAVA_INT, layout.byteOffset(groupElement("pt"), groupElement("x")));
    }

    public static int y(MemorySegment struct) {
        return struct.get(ValueLayout.JAVA_INT, layout.byteOffset(groupElement("pt"), groupElement("y")));
    }

    private MSLLHOOKSTRUCT() {
    }
}
