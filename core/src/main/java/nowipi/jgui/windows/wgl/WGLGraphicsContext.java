package nowipi.jgui.windows.wgl;

import nowipi.jgui.windows.ffm.wgl.Opengl32Impl;
import nowipi.opengl.GraphicsContext;
import nowipi.jgui.windows.ffm.wgl.Opengl32;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

public final class WGLGraphicsContext implements GraphicsContext {


    private final MemorySegment hDC;
    private final MemorySegment hRC;
    private static final Opengl32 opengl32 = new Opengl32Impl();

    public WGLGraphicsContext(MemorySegment hDC) {
        this.hDC = hDC;
        MemorySegment tempContext = opengl32.wglCreateContext(hDC);
        opengl32.wglMakeCurrent(hDC, tempContext);

        int[] contextAttribs = {
                Opengl32.WGL_CONTEXT_MAJOR_VERSION_ARB, 3,
                Opengl32.WGL_CONTEXT_MINOR_VERSION_ARB, 3,
                Opengl32.WGL_CONTEXT_PROFILE_MASK_ARB, Opengl32.WGL_CONTEXT_CORE_PROFILE_BIT_ARB,
                0
        };
        hRC = opengl32.wglCreateContextAttribsARB(hDC, MemorySegment.NULL, contextAttribs);
        opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        opengl32.wglDeleteContext(tempContext);
    }

    @Override
    public void makeCurrent() {
        opengl32.wglMakeCurrent(hDC, hRC);
    }


    @Override
    public MethodHandle getMethodHandle(String methodName, FunctionDescriptor descriptor) {
        return null;
    }

    @Override
    public void dispose() {
        opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        opengl32.wglDeleteContext(hRC);
    }
}
