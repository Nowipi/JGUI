package nowipi.rendering;

import nowipi.ffm.win32.wgl.Opengl32;
import nowipi.windowing.OpenGLImplementation;
import nowipi.windowing.win32.GDIDrawingSurface;

import java.lang.foreign.MemorySegment;

public final class WGLGraphicsContext extends GraphicsContext<GDIDrawingSurface> {

    private final MemorySegment hRC;

    public WGLGraphicsContext(GDIDrawingSurface surface) {
        super(surface);

        MemorySegment tempContext = Opengl32.wglCreateContext(surface.getNativeHandle());
        Opengl32.wglMakeCurrent(surface.getNativeHandle(), tempContext);

        OpenGLImplementation implementation = new Opengl32OpenGLImplementation();
        Opengl32.init(implementation);

        int[] contextAttribs = {
                Opengl32.WGL_CONTEXT_MAJOR_VERSION_ARB, 3,
                Opengl32.WGL_CONTEXT_MINOR_VERSION_ARB, 3,
                Opengl32.WGL_CONTEXT_FLAGS_ARB, 0,
                0
        };
        hRC = Opengl32.wglCreateContextAttribsARB(surface.getNativeHandle(), MemorySegment.NULL, contextAttribs);
        Opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        Opengl32.wglDeleteContext(tempContext);

        OpenGL.init(implementation);
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
