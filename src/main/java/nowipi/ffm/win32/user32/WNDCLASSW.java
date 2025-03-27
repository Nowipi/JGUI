package nowipi.ffm.win32.user32;

import nowipi.ffm.c.C;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

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

    public static void setLpfnWndProc(MemorySegment wndClass, MemorySegment lpfnWndProc) {
        MemoryLayout.PathElement path = groupElement("lpfnWndProc");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), lpfnWndProc);
    }

    public static void sethCursor(MemorySegment wndClass, MemorySegment hCursor) {
        MemoryLayout.PathElement path = groupElement("hCursor");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), hCursor);
    }

    private WNDCLASSW() {
    }
}
