package nowipi.jgui.windows.wgl;

import nowipi.opengl.GraphicsContext;
import nowipi.jgui.windows.ffm.wgl.Opengl32;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

public final class WGLGraphicsContext implements GraphicsContext {


    private final MemorySegment hDC;
    private final MemorySegment hRC;

    public WGLGraphicsContext(MemorySegment hDC) {
        this.hDC = hDC;
        MemorySegment tempContext = Opengl32.wglCreateContext(hDC);
        Opengl32.wglMakeCurrent(hDC, tempContext);

        int[] contextAttribs = {
                Opengl32.WGL_CONTEXT_MAJOR_VERSION_ARB, 3,
                Opengl32.WGL_CONTEXT_MINOR_VERSION_ARB, 3,
                Opengl32.WGL_CONTEXT_PROFILE_MASK_ARB, Opengl32.WGL_CONTEXT_CORE_PROFILE_BIT_ARB,
                0
        };
        hRC = Opengl32.wglCreateContextAttribsARB(hDC, MemorySegment.NULL, contextAttribs);
        Opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        Opengl32.wglDeleteContext(tempContext);
    }

    @Override
    public void makeCurrent() {
        Opengl32.wglMakeCurrent(hDC, hRC);
    }


    @Override
    public MethodHandle getMethodHandle(String methodName, FunctionDescriptor descriptor) {
        return Opengl32.getMethodHandle(methodName, descriptor);
    }

    @Override
    public void dispose() {
        Opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        Opengl32.wglDeleteContext(hRC);
    }
}
