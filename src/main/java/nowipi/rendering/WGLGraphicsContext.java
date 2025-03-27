package nowipi.rendering;

import nowipi.ffm.win32.wgl.Opengl32;
import nowipi.windowing.win32.GDIDrawingSurface;

import java.lang.foreign.MemorySegment;

public final class WGLGraphicsContext extends GraphicsContext<GDIDrawingSurface> {

    private final MemorySegment hRC;

    public WGLGraphicsContext(GDIDrawingSurface surface) {
        super(surface);
        hRC = Opengl32.wglCreateContext(surface.getNativeHandle());
        OpenGL.init(new Opengl32OpenGLImplementation());
    }

    @Override
    public void makeCurrent() {
        Opengl32.wglMakeCurrent(surface.getNativeHandle(), hRC);
    }

    @Override
    public void dispose() {
        Opengl32.wglDeleteContext(hRC);
    }
}
