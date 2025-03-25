package nowipi.windowing;

import nowipi.ffm.win32.gdi.GDI32;
import nowipi.ffm.win32.gdi.PIXELFORMATDESCRIPTOR;
import nowipi.ffm.win32.user32.MSG;
import nowipi.ffm.win32.user32.User32;
import nowipi.ffm.win32.user32.WNDCLASSW;
import nowipi.ffm.win32.wgl.Opengl32;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.charset.StandardCharsets;

import static nowipi.ffm.win32.user32.User32.*;

public class Win32Window extends Window {

    private static final MemorySegment CLASS_NAME;

    private final MemorySegment hWnd;
    private final MemorySegment hDC;
    private final MemorySegment hRC;

    static {
        CLASS_NAME = arena.allocateFrom("Better Java Gui", StandardCharsets.UTF_16LE);
        MemorySegment wc = WNDCLASSW.allocate(arena);
        WNDCLASSW.setLpszClassName(wc, CLASS_NAME);
        try {
            MethodHandle hWndProc = MethodHandles.lookup().findStatic(Win32Window.class, "windowProc",
                    MethodType.methodType(long.class,
                            MemorySegment.class,
                            int.class,
                            long.class,
                            long.class
                    ));
            WNDCLASSW.setLpfnWndProc(wc, User32.getWndProcUpCall(hWndProc));
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        WNDCLASSW.sethCursor(wc, User32.loadCursorA(MemorySegment.NULL, User32.IDC_ARROW));


        User32.registerClassW(wc);
    }


    public Win32Window(String title, int width, int height) {
        super(title, width, height);

        hWnd = User32.createWindowExW(
                0,
                CLASS_NAME,
                arena.allocateFrom(title, StandardCharsets.UTF_16LE),
                WS_OVERLAPPEDWINDOW,
                CW_USEDEFAULT, CW_USEDEFAULT, width, height,
                MemorySegment.NULL,
                MemorySegment.NULL,
                MemorySegment.NULL,
                MemorySegment.NULL
        );

        if (hWnd.equals(MemorySegment.NULL)) {
            throw new RuntimeException("Failed to create window");
        }

        hDC = User32.getDC(hWnd);

        MemorySegment pfd = PIXELFORMATDESCRIPTOR.allocate(arena);
        PIXELFORMATDESCRIPTOR.setNSize(pfd, (short) pfd.byteSize());
        PIXELFORMATDESCRIPTOR.setNVersion(pfd, (short) 1);
        PIXELFORMATDESCRIPTOR.setDwFlags(pfd, GDI32.PFD_DRAW_TO_WINDOW | GDI32.PFD_SUPPORT_OPENGL | GDI32.PFD_DOUBLEBUFFER);
        PIXELFORMATDESCRIPTOR.setIPixelType(pfd, GDI32.PFD_TYPE_RGBA);
        PIXELFORMATDESCRIPTOR.setCColorBits(pfd, (byte) 32);

        int pf = GDI32.choosePixelFormat(hDC, pfd);
        if (pf == 0) {
            throw new RuntimeException("ChoosePixelFormat() failed: Cannot find a suitable pixel format.");
        }

        if (GDI32.setPixelFormat(hDC, pf, pfd) == 0) {
            throw new RuntimeException("SetPixelFormat() failed: Cannot set format specified.");
        }

        GDI32.describePixelFormat(hDC, pf, (int) PIXELFORMATDESCRIPTOR.sizeof(), pfd);


        hRC = Opengl32.wglCreateContext(hDC);
        Opengl32.wglMakeCurrent(hDC, hRC);

        User32.showWindow(hWnd, SW_SHOW);
    }

    @Override
    public boolean shouldClose() {
        return !User32.IsWindowVisible(hWnd);
    }

    @Override
    public void pollEvents() {
        try(Arena arena = Arena.ofConfined()) {
            MemorySegment msg = MSG.allocate(arena);
            while (User32.peekMessageW(msg, MemorySegment.NULL, 0, 0, PM_REMOVE) > 0) {
                User32.translateMessage(msg);
                User32.dispatchMessageW(msg);
            }
        }
    }

    @Override
    public void swapBuffers() {
        GDI32.swapBuffers(hDC);
    }

    private static long windowProc(MemorySegment hwnd, int uMsg, long wParam, long lParam) {
        switch (uMsg){
            case WM_PAINT:
                User32.validateRect(hwnd, MemorySegment.NULL);
                return 0;
            default:
                return User32.defWindowProcW(hwnd, uMsg, wParam, lParam);
        }
    }

    @Override
    public void close() {
        Opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        Opengl32.wglDeleteContext(hRC);
        User32.releaseDC(hWnd, hDC);
        User32.destroyWindow(hWnd);
    }
}
