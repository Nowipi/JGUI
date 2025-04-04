package nowipi.jgui.windows.ffm.gdi;

import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.*;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

public final class PIXELFORMATDESCRIPTOR {
    private static final GroupLayout layout = MemoryLayout.structLayout(
            C.SHORT.withName("nSize"),
            C.SHORT.withName("nVersion"),
            C.LONG.withName("dwFlags"),
            C.CHAR.withName("iPixelType"),
            C.CHAR.withName("cColorBits"),
            C.CHAR.withName("cRedBits"),
            C.CHAR.withName("cRedShift"),
            C.CHAR.withName("cGreenBits"),
            C.CHAR.withName("cGreenShift"),
            C.CHAR.withName("cBlueBits"),
            C.CHAR.withName("cBlueShift"),
            C.CHAR.withName("cAlphaBits"),
            C.CHAR.withName("cAlphaShift"),
            C.CHAR.withName("cAccumBits"),
            C.CHAR.withName("cAccumRedBits"),
            C.CHAR.withName("cAccumGreenBits"),
            C.CHAR.withName("cAccumBlueBits"),
            C.CHAR.withName("cAccumAlphaBits"),
            C.CHAR.withName("cDepthBits"),
            C.CHAR.withName("cStencilBits"),
            C.CHAR.withName("cAuxBuffers"),
            C.CHAR.withName("iLayerType"),
            C.CHAR.withName("bReserved"),
            C.LONG.withName("dwLayerMask"),
            C.LONG.withName("dwVisibleMask"),
            C.LONG.withName("dwDamageMask")
    ).withName("PIXELFORMATDESCRIPTOR");

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout);
    }

    public static void setNSize(MemorySegment pfd, short nSize) {
        MemoryLayout.PathElement path = groupElement("nSize");
        pfd.set((ValueLayout.OfShort) layout.select(path), layout.byteOffset(path), nSize);
    }

    public static void setNVersion(MemorySegment pfd, short nVersion) {
        MemoryLayout.PathElement path = groupElement("nVersion");
        pfd.set((ValueLayout.OfShort) layout.select(path), layout.byteOffset(path), nVersion);
    }

    public static void setDwFlags(MemorySegment pfd, int dwFlags) {
        MemoryLayout.PathElement path = groupElement("dwFlags");
        pfd.set((ValueLayout.OfInt) layout.select(path), layout.byteOffset(path), dwFlags);
    }

    public static void setIPixelType(MemorySegment pfd, byte iPixelType) {
        MemoryLayout.PathElement path = groupElement("iPixelType");
        pfd.set((ValueLayout.OfByte) layout.select(path), layout.byteOffset(path), iPixelType);
    }

    public static void setCColorBits(MemorySegment pfd, byte cColorBits) {
        MemoryLayout.PathElement path = groupElement("cColorBits");
        pfd.set((ValueLayout.OfByte) layout.select(path), layout.byteOffset(path), cColorBits);
    }

    public static void setILayerType(MemorySegment pfd, byte iLayerType) {
        MemoryLayout.PathElement path = groupElement("iLayerType");
        pfd.set((ValueLayout.OfByte) layout.select(path), layout.byteOffset(path), iLayerType);
    }

    public static long sizeof() {
        return layout.byteSize();
    }
}
