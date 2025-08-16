package nowipi.jgui.windows.window;

import nowipi.jgui.Rectangle;
import nowipi.jgui.event.EventDispatcher;
import nowipi.jgui.input.keyboard.KeyboardEventListener;
import nowipi.jgui.window.event.WindowEventListener;
import nowipi.jgui.window.PixelFormat;
import nowipi.jgui.window.Window;
import nowipi.jgui.event.ArrayListEventDispatcher;
import nowipi.jgui.window.event.WindowMouseListener;
import nowipi.jgui.windows.ffm.gdi.GDI32;
import nowipi.jgui.windows.ffm.gdi.PIXELFORMATDESCRIPTOR;
import nowipi.jgui.windows.ffm.user32.MSG;
import nowipi.jgui.windows.ffm.user32.RECT;
import nowipi.jgui.windows.ffm.user32.User32;

import java.lang.foreign.*;
import java.nio.charset.StandardCharsets;

import static nowipi.jgui.windows.ffm.Win32.gdi32;
import static nowipi.jgui.windows.ffm.Win32.user32;

public class Win32Window implements Window {

    public class DeviceContext implements AutoCloseable {

        private final MemorySegment hDC;

        public DeviceContext() {
            hDC = user32.getDC(hWnd);
        }

        public void swapBuffers() {
            gdi32.swapBuffers(hDC);
        }

        public void setPixelFormat(PixelFormat format) {
            try(Arena arena = Arena.ofConfined()) {
                MemorySegment pfd = PIXELFORMATDESCRIPTOR.allocate(arena);
                PIXELFORMATDESCRIPTOR.setNSize(pfd, (short) pfd.byteSize());
                PIXELFORMATDESCRIPTOR.setNVersion(pfd, (short) 1);
                PIXELFORMATDESCRIPTOR.setDwFlags(pfd, GDI32.PFD_DRAW_TO_WINDOW | GDI32.PFD_SUPPORT_OPENGL | GDI32.PFD_DOUBLEBUFFER);
                PIXELFORMATDESCRIPTOR.setIPixelType(pfd, switch (format.colorSpace()) { case PixelFormat.ColorSpace.RGBA -> GDI32.PFD_TYPE_RGBA;});
                PIXELFORMATDESCRIPTOR.setCColorBits(pfd, (byte) format.colorBits());
                PIXELFORMATDESCRIPTOR.setILayerType(pfd, (byte) GDI32.PFD_MAIN_PLANE);

                int pixelFormat = gdi32.choosePixelFormat(hDC, pfd);

                gdi32.setPixelFormat(hDC, pixelFormat, pfd);
            }
        }

        @Override
        public void close() {
            user32.releaseDC(hWnd, hDC);
        }

        public MemorySegment handle() {
            return hDC;
        }
    }

    private final MemorySegment hWnd;
    private final DeviceContext deviceContext;
    private final EventDispatcher<WindowEventListener> windowEventDispatcher;
    private final EventDispatcher<WindowMouseListener> mouseEventDispatcher;
    private final EventDispatcher<KeyboardEventListener> keyboardEventDispatcher;

    public Win32Window(MemorySegment hWnd) {
        this.hWnd = hWnd;
        deviceContext = new DeviceContext();
        deviceContext.setPixelFormat(new PixelFormat(PixelFormat.ColorSpace.RGBA, 32, 24, 8));

        windowEventDispatcher = new ArrayListEventDispatcher<>();
        mouseEventDispatcher = new ArrayListEventDispatcher<>();
        keyboardEventDispatcher = new ArrayListEventDispatcher<>();
    }

    @Override
    public void addListener(WindowEventListener listener) {
        windowEventDispatcher.addListener(listener);
    }

    @Override
    public void addListener(WindowMouseListener listener) {
        mouseEventDispatcher.addListener(listener);
    }

    @Override
    public void addListener(KeyboardEventListener listener) {
        keyboardEventDispatcher.addListener(listener);
    }

    @Override
    public void show() {
        user32.showWindow(hWnd, User32.SW_SHOW);
    }

    @Override
    public boolean shouldClose() {
        return !user32.isWindowVisible(hWnd);
    }

    @Override
    public void pollEvents() {
        try(Arena arena = Arena.ofConfined()) {
            MemorySegment msg = MSG.allocate(arena);
            while (user32.peekMessage(msg, hWnd, 0, 0, User32.PM_REMOVE) > 0) {
                user32.translateMessage(msg);
                user32.dispatchMessage(msg);
            }
        }
    }

    @Override
    public void swapBuffers() {
        deviceContext.swapBuffers();
    }

    @Override
    public String title() {
        try(Arena arena = Arena.ofConfined()) {
            int bufferSize = 512;
            MemorySegment buffer = arena.allocate(bufferSize * 2);
            user32.getWindowText(hWnd, buffer, bufferSize);

            return buffer.getString(0, StandardCharsets.UTF_16LE);
        }
    }

    @Override
    public Rectangle bounds() {
        try(Arena arena = Arena.ofConfined()) {
            MemorySegment rect = RECT.allocate(arena);
            user32.getWindowRect(hWnd, rect);

            return new Rectangle(RECT.left(rect), RECT.right(rect), RECT.top(rect), RECT.bottom(rect));
        }
    }

    @Override
    public void setTopLeft(int x, int y) {
        user32.setWindowPos(hWnd, MemorySegment.NULL, x, y, 0, 0, User32.SWP_NOZORDER | User32.SWP_NOSIZE);
    }

    @Override
    public void dispose() {
        deviceContext.close();
        user32.destroyWindow(hWnd);
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

    public DeviceContext deviceContext() {
        return deviceContext;
    }

    protected EventDispatcher<WindowEventListener> windowEventDispatcher() {
        return windowEventDispatcher;
    }

    protected EventDispatcher<WindowMouseListener> mouseEventDispatcher() {
        return mouseEventDispatcher;
    }

    protected EventDispatcher<KeyboardEventListener> keyboardEventDispatcher() {
        return keyboardEventDispatcher;
    }
}
