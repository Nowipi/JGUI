package nowipi.jgui.windows.window;

import nowipi.jgui.opengl.GraphicsContext;
import nowipi.jgui.window.PixelFormat;
import nowipi.jgui.window.Window;
import nowipi.jgui.window.event.MapEventDispatcher;
import nowipi.jgui.window.event.WindowResizeEvent;
import nowipi.jgui.windows.ffm.Win32;
import nowipi.jgui.windows.ffm.gdi.GDI32;
import nowipi.jgui.windows.ffm.gdi.PIXELFORMATDESCRIPTOR;
import nowipi.jgui.windows.ffm.user32.MSG;
import nowipi.jgui.windows.ffm.user32.User32;
import nowipi.jgui.windows.ffm.user32.WNDCLASSW;
import nowipi.jgui.windows.wgl.WGLGraphicsContext;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public final class Win32Window extends MapEventDispatcher implements Window {

    private final MemorySegment hWnd;
    private final MemorySegment hDC;

    public Win32Window(String title, int width, int height) {
        this.hWnd = User32.createWindowExW(
                0,
                CLASS_NAME,
                arena.allocateFrom(title, StandardCharsets.UTF_16LE),
                User32.WS_OVERLAPPEDWINDOW,
                User32.CW_USEDEFAULT, User32.CW_USEDEFAULT, width, height,
                MemorySegment.NULL,
                MemorySegment.NULL,
                MemorySegment.NULL,
                MemorySegment.NULL
        );
        windows.put(hWnd, this);
        hDC = User32.getDC(hWnd);

        setPixelFormat(new PixelFormat(PixelFormat.ColorSpace.RGBA, 32, 24, 8));
    }

    @Override
    public void show() {
        User32.showWindow(hWnd, User32.SW_SHOW);
    }

    @Override
    public boolean shouldClose() {
        return !User32.IsWindowVisible(hWnd);
    }

    @Override
    public void pollEvents() {
        try(Arena arena = Arena.ofConfined()) {
            MemorySegment msg = MSG.allocate(arena);
            while (User32.peekMessageW(msg, hWnd, 0, 0, User32.PM_REMOVE) > 0) {
                User32.translateMessage(msg);
                User32.dispatchMessageW(msg);
            }
        }
    }

    @Override
    public void swapBuffers() {
        GDI32.swapBuffers(hDC);
    }

    @Override
    public GraphicsContext createGraphicsContext() {
        return new WGLGraphicsContext(hDC);
    }

    @Override
    public void setPixelFormat(PixelFormat format) {
        try(Arena arena = Arena.ofConfined()) {
            MemorySegment pfd = PIXELFORMATDESCRIPTOR.allocate(arena);
            PIXELFORMATDESCRIPTOR.setNSize(pfd, (short) pfd.byteSize());
            PIXELFORMATDESCRIPTOR.setNVersion(pfd, (short) 1);
            PIXELFORMATDESCRIPTOR.setDwFlags(pfd, GDI32.PFD_DRAW_TO_WINDOW | GDI32.PFD_SUPPORT_OPENGL | GDI32.PFD_DOUBLEBUFFER);
            PIXELFORMATDESCRIPTOR.setIPixelType(pfd, switch (format.colorSpace()) { case PixelFormat.ColorSpace.RGBA -> GDI32.PFD_TYPE_RGBA;});
            PIXELFORMATDESCRIPTOR.setCColorBits(pfd, (byte) format.colorBits());
            PIXELFORMATDESCRIPTOR.setILayerType(pfd, (byte) GDI32.PFD_MAIN_PLANE);

            int pixelFormat = GDI32.choosePixelFormat(hDC, pfd);

            GDI32.setPixelFormat(hDC, pixelFormat, pfd);
        }
    }

    @Override
    public void dispose() {
        User32.releaseDC(hWnd, hDC);
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
        WNDCLASSW.setStyle(wc, User32.CS_HREDRAW | User32.CS_VREDRAW | User32.CS_OWNDC);


        User32.registerClassW(wc);
        windows = new HashMap<>();
    }

    private static long windowProc(MemorySegment hwnd, int uMsg, long wParam, long lParam) {
        switch (uMsg) {

            case User32.WM_SIZE -> {
                var window = windows.get(hwnd);
                int width = Win32.loWord(lParam);
                int height = Win32.hiWord(lParam);
                window.dispatch(WindowResizeEvent.class, new WindowResizeEvent(width, height));
                return 0;
            }
            case User32.WM_PAINT -> {
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
