package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.Win32;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class KBDLLHOOKSTRUCT {

    private static final MemoryLayout layout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("vkCode"),
            ValueLayout.JAVA_INT.withName("scanCode"),
            ValueLayout.JAVA_INT.withName("flags"),
            ValueLayout.JAVA_INT.withName("time"),
            ValueLayout.ADDRESS.withName("dwExtraInfo")
    ).withName("tagKBDLLHOOKSTRUCT");

    private KBDLLHOOKSTRUCT() {
    }

    public static MemorySegment ofAddress(long address) {
        return MemorySegment.ofAddress(address).reinterpret(layout.byteSize(), Win32.arena, null);
    }

    public static int vkCode(MemorySegment struct) {
        return struct.get(ValueLayout.JAVA_INT, layout.byteOffset(groupElement("vkCode")));
    }
}
