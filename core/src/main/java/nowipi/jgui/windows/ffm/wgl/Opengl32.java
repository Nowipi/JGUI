package nowipi.jgui.windows.ffm.wgl;

import io.github.nowipi.ffm.processor.annotations.Function;
import io.github.nowipi.ffm.processor.annotations.Library;
import nowipi.jgui.windows.ffm.C;

import java.lang.foreign.*;

@Library("opengl32")
public interface Opengl32 {

    int WGL_CONTEXT_MAJOR_VERSION_ARB = 0x2091;
    int WGL_CONTEXT_MINOR_VERSION_ARB = 0x2092;
    int WGL_CONTEXT_PROFILE_MASK_ARB  = 0x9126;
    int WGL_CONTEXT_CORE_PROFILE_BIT_ARB  = 0x00000001;


    @Function("wglCreateContext")
    MemorySegment wglCreateContext(MemorySegment hDC);

    @Function("wglMakeCurrent")
    int wglMakeCurrent(MemorySegment hDC, MemorySegment hRC);

    @Function("wglGetProcAddress")
    MemorySegment wglGetProcAddress(MemorySegment unnamedParam1);

    @Function("wglDeleteContext")
    int wglDeleteContext(MemorySegment unnamedParam1);

    default MemorySegment wglCreateContextAttribsARB(MemorySegment hDC, MemorySegment hShareContext, int[] attribList) {
        try(var arena = Arena.ofConfined()) {
            return wglCreateContextAttribsARB(hDC, hShareContext, arena.allocateFrom(C.INT, attribList));
        }
    }

    @Function("wglCreateContextAttribsARB")
    MemorySegment wglCreateContextAttribsARB(MemorySegment hDC, MemorySegment hShareContext, MemorySegment attribList);

}
