package nowipi.jgui.windows.ffm.gdi;

import io.github.nowipi.ffm.processor.annotations.Function;
import io.github.nowipi.ffm.processor.annotations.Library;

import java.lang.foreign.MemorySegment;

@Library("gdi32")
public interface GDI32 {

    int PFD_SUPPORT_OPENGL = 0x00000020;
    int PFD_DRAW_TO_WINDOW = 0x00000004;
    int PFD_DOUBLEBUFFER = 0x00000001;
    byte PFD_TYPE_RGBA = 0;
    int PFD_MAIN_PLANE = 0;

    @Function("ChoosePixelFormat")
    int choosePixelFormat(MemorySegment hDC, MemorySegment hRC);

    @Function("SetPixelFormat")
    int setPixelFormat(MemorySegment hdc, int format, MemorySegment ppfd);

    @Function("SwapBuffers")
    int swapBuffers(MemorySegment hDC);

}
