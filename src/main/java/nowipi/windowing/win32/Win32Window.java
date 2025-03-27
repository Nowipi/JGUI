package nowipi.windowing.win32;

import nowipi.event.MapEventDispatcher;
import nowipi.ffm.win32.Win32;
import nowipi.ffm.win32.gdi.GDI32;
import nowipi.ffm.win32.user32.MSG;
import nowipi.ffm.win32.user32.PAINTSTRUCT;
import nowipi.ffm.win32.user32.User32;
import nowipi.ffm.win32.user32.WNDCLASSW;
import nowipi.ffm.win32.wgl.Opengl32;
import nowipi.windowing.DrawingSurface;
import nowipi.windowing.PixelFormat;
import nowipi.windowing.Window;
import nowipi.windowing.event.WindowResizeEvent;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static nowipi.ffm.win32.user32.User32.*;

public final class Win32Window extends MapEventDispatcher implements Window {

    private final MemorySegment hWnd;
    private final DrawingSurface surface;

    public Win32Window(String title, int width, int height) {
        this.hWnd = User32.createWindowExW(
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
        windows.put(hWnd, this);
        this.surface = new GDIDrawingSurface(hWnd);
        surface.setPixelFormat(new PixelFormat(PixelFormat.ColorSpace.RGBA, 32, 24, 8));
    }

    @Override
    public void show() {
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
        surface.swapBuffers();
    }

    @Override
    public DrawingSurface getDrawingSurface() {
        return surface;
    }

    @Override
    public void dispose() {
        Opengl32.wglMakeCurrent(MemorySegment.NULL, MemorySegment.NULL);
        surface.dispose();
        User32.destroyWindow(hWnd);
    }

    private static final MemorySegment CLASS_NAME;
    private static final Arena arena;
    private static final Map<MemorySegment, Win32Window> windows;

    static {
        arena = Arena.ofAuto();
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
        WNDCLASSW.setStyle(wc, CS_OWNDC);


        User32.registerClassW(wc);
        windows = new HashMap<>();
    }

    private static long windowProc(MemorySegment hwnd, int uMsg, long wParam, long lParam) {
        switch (uMsg) {

            case WM_SIZE -> {
                var window = windows.get(hwnd);
                int width = Win32.loWord(lParam);
                int height = Win32.hiWord(lParam);
                window.dispatch(WindowResizeEvent.class, new WindowResizeEvent(width, height));
                return 0;
            }
            case WM_PAINT -> {
                User32.validateRect(hwnd, MemorySegment.NULL);
                return 0;

            }
        }
        return User32.defWindowProcW(hwnd, uMsg, wParam, lParam);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Win32Window that)) return false;

        return hWnd.equals(that.hWnd);
    }

    @Override
    public int hashCode() {
        return hWnd.hashCode();
    }
}
