package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.*;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class WNDCLASSEXW {
    public static final MemoryLayout layout = MemoryLayout.structLayout(
            C.INT.withName("cbSize"),
            C.INT.withName("style"),
            C.POINTER.withName("lpfnWndProc"),
            C.INT.withName("cbClsExtra"),
            C.INT.withName("cbWndExtra"),
            C.POINTER.withName("hInstance"),
            C.POINTER.withName("hIcon"),
            C.POINTER.withName("hCursor"),
            C.POINTER.withName("hbrBackground"),
            C.POINTER.withName("lpszMenuName"),
            C.POINTER.withName("lpszClassName"),
            C.POINTER.withName("hIconSm")
    ).withName("tagWNDCLASSEXW");

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static void setCbSize(MemorySegment wndClass, int cbSize) {
        MemoryLayout.PathElement path = groupElement("cbSize");
        wndClass.set(C.INT, layout.byteOffset(path), cbSize);
    }

    public static void setStyle(MemorySegment wndClass, int style) {
        MemoryLayout.PathElement path = groupElement("style");
        wndClass.set(C.INT, layout.byteOffset(path), style);
    }

    public static void setLpszClassName(MemorySegment wndClass, MemorySegment wndClassName) {
        MemoryLayout.PathElement path = groupElement("lpszClassName");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), wndClassName);
    }

    public static void setLpfnWndProc(MemorySegment wndClass, MemorySegment address) {
        MemoryLayout.PathElement path = groupElement("lpfnWndProc");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), address);
    }

    public static void sethCursor(MemorySegment wndClass, MemorySegment hCursor) {
        MemoryLayout.PathElement path = groupElement("hCursor");
        wndClass.set((AddressLayout) layout.select(path), layout.byteOffset(path), hCursor);
    }
}
