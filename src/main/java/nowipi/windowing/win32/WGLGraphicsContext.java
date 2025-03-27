package nowipi.windowing.win32;

import nowipi.ffm.win32.wgl.Opengl32;
import nowipi.windowing.GraphicsContext;
import nowipi.windowing.OpenGL;

import java.lang.foreign.MemorySegment;

public class WGLGraphicsContext extends GraphicsContext<Win32DrawingSurface> {

    private final MemorySegment hRC;

    public WGLGraphicsContext(Win32DrawingSurface surface) {
        super(surface);
        hRC = Opengl32.wglCreateContext(surface.hDC());
        OpenGL.init(new Opengl32());
    }

    @Override
    public void makeCurrent() {
        Opengl32.wglMakeCurrent(surface.hDC(), hRC);
    }

    MemorySegment hRC() {
        return hRC;
    }

    @Override
    public void dispose() {
        Opengl32.wglDeleteContext(hRC);
    }
}
