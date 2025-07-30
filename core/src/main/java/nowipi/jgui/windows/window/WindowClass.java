package nowipi.jgui.windows.window;

import nowipi.jgui.input.keyboard.Key;
import nowipi.jgui.input.mouse.Button;
import nowipi.jgui.windows.ffm.Win32;
import nowipi.jgui.windows.ffm.user32.User32;
import nowipi.jgui.windows.ffm.user32.WNDCLASSEXW;
import nowipi.jgui.windows.input.Win32Keyboard;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static nowipi.jgui.windows.ffm.Win32.user32;
import static nowipi.jgui.windows.ffm.user32.User32.*;

public final class WindowClass {

    private final Arena globalInstanceArena;
    private final MemorySegment name;
    private final Map<MemorySegment, Win32Window> instances;

    public WindowClass(String name) {
        globalInstanceArena = Arena.ofAuto();
        try(Arena tempArena = Arena.ofConfined()) {
            this.name = globalInstanceArena.allocateFrom(name, StandardCharsets.UTF_16LE);
            instances = new HashMap<>();

            MemorySegment windowClass = WNDCLASSEXW.allocate(tempArena);
            windowClass.fill((byte) 0);

            WNDCLASSEXW.setCbSize(windowClass, (int) WNDCLASSEXW.layout.byteSize());

            WNDCLASSEXW.setLpszClassName(windowClass, this.name);

            MethodHandle hWndProc = MethodHandles.lookup().bind(this, "windowProc",
                    MethodType.methodType(long.class,
                            MemorySegment.class,
                            int.class,
                            long.class,
                            long.class
                    ));
            FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);

            WNDCLASSEXW.setLpfnWndProc(windowClass, Linker.nativeLinker().upcallStub(hWndProc, descriptor, globalInstanceArena));



            WNDCLASSEXW.sethCursor(windowClass, user32.loadCursorA(MemorySegment.NULL, User32.IDC_ARROW));
            WNDCLASSEXW.setStyle(windowClass, User32.CS_HREDRAW | User32.CS_VREDRAW | User32.CS_OWNDC);

            WNDCLASSEXW.setHbrBackground(windowClass, MemorySegment.NULL);

            user32.registerClassEx(windowClass);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public WindowedWin32Window createWindowedInstance(String title, int width, int height) {
        MemorySegment hWnd = createWindow(title, width, height, WS_OVERLAPPEDWINDOW);
        WindowedWin32Window window = new WindowedWin32Window(hWnd);
        instances.put(hWnd, window);
        return window;
    }

    public Win32Window createInstance(String title, int width, int height, int style) {
        MemorySegment hWnd = createWindow(title, width, height, style);
        Win32Window window = new Win32Window(hWnd);
        instances.put(hWnd, window);
        return window;
    }

    private MemorySegment createWindow(String title, int width, int height, int style) {
        try(Arena tempArena = Arena.ofConfined()) {
            return user32.createWindowEx(
                    0,
                    name,
                    tempArena.allocateFrom(title, StandardCharsets.UTF_16LE),
                    style,
                    User32.CW_USEDEFAULT, User32.CW_USEDEFAULT, width, height,
                    MemorySegment.NULL,
                    MemorySegment.NULL,
                    MemorySegment.NULL,
                    MemorySegment.NULL
            );
        }
    }

    private long windowProc(MemorySegment hwnd, int uMsg, long wParam, long lParam) {
        switch (uMsg) {
            case User32.WM_SIZE -> {
                Win32Window window = instances.get(hwnd);
                int width = Win32.loWord(lParam);
                int height = Win32.hiWord(lParam);
                window.windowEventDispatcher().dispatch(l -> l.resize(width, height));
            }
            case WM_MOUSEMOVE -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.move(x, y));
            }
            case WM_LBUTTONDOWN -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.press(Button.LEFT, x, y));
            }
            case WM_LBUTTONUP -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.release(Button.LEFT, x, y));
            }
            case WM_RBUTTONDOWN -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.press(Button.RIGHT, x, y));
            }
            case WM_RBUTTONUP -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.release(Button.RIGHT, x, y));
            }
            case WM_MBUTTONDOWN -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.press(Button.MIDDLE, x, y));
            }
            case WM_MBUTTONUP -> {
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                window.mouseEventDispatcher().dispatch(l -> l.release(Button.MIDDLE, x, y));
            }
            case WM_XBUTTONDOWN -> {
                int highOrder = Win32.hiWord(wParam);
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                switch (highOrder) {
                    case 0x0001:
                        window.mouseEventDispatcher().dispatch(l -> l.press(Button.X1, x, y));
                        break;
                    case 0x0002:
                        window.mouseEventDispatcher().dispatch(l -> l.press(Button.X2, x, y));
                        break;
                }

            }
            case WM_XBUTTONUP -> {
                int highOrder = Win32.hiWord(wParam);
                Win32Window window = instances.get(hwnd);
                int x = Win32.loWord(lParam);
                int y = Win32.hiWord(lParam);
                switch (highOrder) {
                    case 0x0001:
                        window.mouseEventDispatcher().dispatch(l -> l.release(Button.X1, x, y));
                        break;
                    case 0x0002:
                        window.mouseEventDispatcher().dispatch(l -> l.release(Button.X2, x, y));
                        break;
                }
            }
            case WM_KEYDOWN -> {
                Win32Window window = instances.get(hwnd);
                Key pressedKey = Win32Keyboard.win32VirtualKeyToKey((int) wParam);
                window.keyboardEventDispatcher().dispatch(l -> l.press(pressedKey));
            }
            case WM_KEYUP -> {
                Win32Window window = instances.get(hwnd);
                Key releasedKey = Win32Keyboard.win32VirtualKeyToKey((int) wParam);
                window.keyboardEventDispatcher().dispatch(l -> l.release(releasedKey));
            }
            default -> {
                return user32.defWindowProc(hwnd, uMsg, wParam, lParam);
            }
        }
        return 1;
    }

    public MemorySegment name() {
        return name;
    }
}
