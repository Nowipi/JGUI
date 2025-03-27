package nowipi.windowing.win32;

import nowipi.ffm.win32.gdi.GDI32;
import nowipi.ffm.win32.gdi.PIXELFORMATDESCRIPTOR;
import nowipi.ffm.win32.user32.User32;
import nowipi.windowing.DrawingSurface;
import nowipi.windowing.PixelFormat;

import java.lang.foreign.MemorySegment;

import static nowipi.ffm.win32.user32.User32.arena;

public class Win32DrawingSurface implements DrawingSurface {

    private final MemorySegment hWnd;
    private final MemorySegment hDC;

    public Win32DrawingSurface(MemorySegment hWnd) {
        this.hWnd = hWnd;
        this.hDC = User32.getDC(hWnd);
    }

    MemorySegment hDC() {
        return hDC;
    }

    @Override
    public void setPixelFormat(PixelFormat format) {
        MemorySegment pfd = PIXELFORMATDESCRIPTOR.allocate(arena);
        PIXELFORMATDESCRIPTOR.setNSize(pfd, (short) pfd.byteSize());
        PIXELFORMATDESCRIPTOR.setNVersion(pfd, (short) 1);
        PIXELFORMATDESCRIPTOR.setDwFlags(pfd, GDI32.PFD_DRAW_TO_WINDOW | GDI32.PFD_SUPPORT_OPENGL | GDI32.PFD_DOUBLEBUFFER);
        PIXELFORMATDESCRIPTOR.setIPixelType(pfd, switch (format.colorSpace()) { case RGBA -> GDI32.PFD_TYPE_RGBA;});
        PIXELFORMATDESCRIPTOR.setCColorBits(pfd, (byte) format.colorBits());

        int pixelFormat = GDI32.choosePixelFormat(hDC, pfd);

        GDI32.setPixelFormat(hDC, pixelFormat, pfd);
    }

    @Override
    public void swapBuffers() {
        GDI32.swapBuffers(hDC);
    }

    @Override
    public void dispose() {
        User32.releaseDC(hWnd, hDC);
    }
}
