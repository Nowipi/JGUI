package nowipi.ffm.win32.user32;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;

public class User32 {

    public static final int WS_OVERLAPPEDWINDOW = 0x00C00000 | 0x00080000 | 0x00040000 | 0x00020000 | 0x00010000;
    public static final int CW_USEDEFAULT = 0x80000000;
    public static final int SW_SHOW = 5;
    public static final int PM_REMOVE = 0x0001;

    public static final int WM_CREATE = 0x0001;
    public static final int WM_DESTROY = 0x0002;
    public static final int WM_MOVE = 0x0003;
    public static final int WM_SIZE = 0x0005;
    public static final int WM_PAINT = 0x000F;
    public static final int WM_KEYDOWN = 0x0100;
    public static final int WM_KEYUP = 0x0101;


    public static final MemorySegment IDC_ARROW = MemorySegment.ofAddress(32512L);

    public static final Arena arena;
    public static final SymbolLookup lookup;

    static {
        arena = Arena.ofConfined();
        lookup = SymbolLookup.libraryLookup(System.mapLibraryName("user32"), arena);
    }


    public static short registerClassW(MemorySegment wndClass) {
        try {
            return (short) RegisterClassW.handle.invokeExact(wndClass);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MemorySegment createWindowExW(int dwExStyle, MemorySegment lpClassName, MemorySegment lpWindowName, int dwStyle, int X, int Y, int nWidth, int nHeight, MemorySegment hWndParent, MemorySegment hMenu, MemorySegment hInstance, MemorySegment lpParam) {
        try {
            return (MemorySegment) CreateWindowExW.handle.invokeExact(
                    dwExStyle,
                    lpClassName,
                    lpWindowName,
                    dwStyle,
                    X, Y, nWidth, nHeight,
                    hWndParent,
                    hMenu,
                    hInstance,
                    lpParam
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int showWindow(MemorySegment hWnd, int nCmdShow) {
        try {
            return (int) ShowWindow.handle.invokeExact(hWnd, nCmdShow);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int peekMessageW(MemorySegment lpMsg, MemorySegment hWnd, int wMsgFilterMin, int wMsgFilterMax, int wRemoveMsg) {
        try {
            return (int) PeekMessageW.handle.invokeExact(lpMsg, hWnd, wMsgFilterMin, wMsgFilterMax, wRemoveMsg);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int translateMessage(MemorySegment lpMsg) {
        try {
            return (int) TranslateMessage.handle.invokeExact(lpMsg);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static long dispatchMessageW(MemorySegment lpMsg) {
        try {
            return (long) DispatchMessageW.handle.invokeExact(lpMsg);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static long defWindowProcW(MemorySegment hWnd, int Msg, long wParam, long lParam) {
        try {
            return (long) DefWindowProcW.handle.invokeExact(hWnd, Msg, wParam, lParam);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MemorySegment getWndProcUpCall(MethodHandle wndProc) {
        return Linker.nativeLinker().upcallStub(wndProc, DefWindowProcW.descriptor, arena);
    }

    public static boolean IsWindowVisible(MemorySegment hWnd) {
        try {
            return (boolean) IsWindowVisible.handle.invokeExact(hWnd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int validateRect(MemorySegment hWnd, MemorySegment lpRect) {
        try {
            return (int) ValidateRect.handle.invokeExact(hWnd, lpRect);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MemorySegment loadCursorA(MemorySegment hInstance, MemorySegment lpCursorName) {
        try {
            return (MemorySegment) LoadCursorA.handle.invokeExact(hInstance, lpCursorName);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MemorySegment toUTF16CString(String str) {
        byte[] bytes = (str + "\0").getBytes(StandardCharsets.UTF_16LE); // Ensure UTF-16LE with null terminator
        MemorySegment segment = arena.allocate(bytes.length); // Allocate memory
        segment.copyFrom(MemorySegment.ofArray(bytes)); // Copy bytes into native memory
        return segment; // Return pointer to native string
    }
}
