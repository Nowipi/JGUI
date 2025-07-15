package nowipi.jgui.windows.ffm.user32;

import java.lang.foreign.*;

public final class MOUSEINPUT {

    static final GroupLayout layout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("dx"),
            ValueLayout.JAVA_INT.withName("dy"),
            ValueLayout.JAVA_INT.withName("mouseData"),
            ValueLayout.JAVA_INT.withName("dwFlags"),
            ValueLayout.JAVA_INT.withName("time"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS.withName("dwExtraInfo")
    ).withName("MOUSEINPUT");

    private MOUSEINPUT() {
    }

    public static void setDx(MemorySegment input, int dx) {
        final MemoryLayout.PathElement path = MemoryLayout.PathElement.groupElement("dx");
        input.set((ValueLayout.OfInt) layout.select(path),  layout.byteOffset(path), dx);
    }

    public static void setDy(MemorySegment input, int dx) {
        final MemoryLayout.PathElement path = MemoryLayout.PathElement.groupElement("dy");
        input.set((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path), dx);
    }

    public static void setMouseData(MemorySegment input, int mouseData) {
        final MemoryLayout.PathElement path = MemoryLayout.PathElement.groupElement("mouseData");
        input.set((ValueLayout.OfInt) layout.select(path),  layout.byteOffset(path), mouseData);
    }

    public static void setDwFlags(MemorySegment input, int dwFlags) {
        final MemoryLayout.PathElement path = MemoryLayout.PathElement.groupElement("dwFlags");
        input.set((ValueLayout.OfInt) layout.select(path),  layout.byteOffset(path), dwFlags);
    }

    public static void setTime(MemorySegment input, int time) {
        final MemoryLayout.PathElement path = MemoryLayout.PathElement.groupElement("time");
        input.set((ValueLayout.OfInt) layout.select(path),  layout.byteOffset(path), time);
    }

    public static void setDwExtraInfo(MemorySegment input, MemorySegment dwExtraInfo) {
        final MemoryLayout.PathElement path = MemoryLayout.PathElement.groupElement("dwExtraInfo");
        input.set((AddressLayout) layout.select(path),  layout.byteOffset(path), dwExtraInfo);
    }
}
