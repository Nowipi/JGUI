package nowipi.jgui.windows.ffm.user32;

import nowipi.jgui.windows.ffm.C;
import nowipi.jgui.windows.ffm.Win32;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

public final class User32 {
    public static final int WS_BORDER = 0x00800000;
    public static final int WS_CAPTION = 0x00C00000;
    public static final int WS_CHILD = 0x40000000;
    public static final int WS_CHILDWINDOW = 0x40000000;
    public static final int WS_CLIPCHILDREN	= 0x02000000;
    public static final int WS_CLIPSIBLINGS	= 0x04000000;
    public static final int WS_DISABLED	= 0x08000000;
    public static final int WS_DLGFRAME	= 0x00400000;
    public static final int WS_GROUP	= 0x00020000;
    public static final int WS_HSCROLL	= 0x00100000;
    public static final int WS_ICONIC	= 0x20000000;
    public static final int WS_MAXIMIZE	= 0x01000000;
    public static final int WS_MAXIMIZEBOX	= 0x00010000;
    public static final int WS_MINIMIZE	= 0x20000000;
    public static final int WS_MINIMIZEBOX	= 0x00020000;
    public static final int WS_OVERLAPPED	= 0x00000000;
    public static final int WS_OVERLAPPEDWINDOW	= 0x00CF0000;
    public static final int WS_POPUP	= 0x80000000;
    public static final int WS_POPUPWINDOW	= 0x80880000;
    public static final int WS_SIZEBOX	= 0x00040000;
    public static final int WS_SYSMENU	= 0x00080000;
    public static final int WS_TABSTOP	= 0x00010000;
    public static final int WS_THICKFRAME	= 0x00040000;
    public static final int WS_TILED	= 0x00000000;
    public static final int WS_TILEDWINDOW	= 0x00CF0000;
    public static final int WS_VISIBLE	= 0x10000000;
    public static final int WS_VSCROLL	= 0x00200000;
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
    public static final int WM_SIZING = 0x0214;
    public static final int WM_ENTERSIZEMOVE = 0x0231;
    public static final int WM_EXITSIZEMOVE  = 0x0232;

    public static final int CS_HREDRAW = 0x001;
    public static final int CS_VREDRAW = 0x002;
    public static final int CS_OWNDC = 0x0020;

    public static final int SWP_NOZORDER = 0x0004;
    public static final int SWP_NOSIZE = 0x0001;



    public static final MemorySegment IDC_ARROW = MemorySegment.ofAddress(32512L);

    public static final SymbolLookup lookup;
    public static final int WS_EX_NOPARENTNOTIFY = 0x00000004;

    static {
        lookup = SymbolLookup.libraryLookup(System.mapLibraryName("user32"), Win32.arena);
    }

    private User32() {
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
        return Linker.nativeLinker().upcallStub(wndProc, DefWindowProcW.descriptor, Win32.arena);
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

    public static int destroyWindow(MemorySegment hWnd) {
        try {
            return (int) DestroyWindow.handle.invokeExact(hWnd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static MemorySegment getDC(MemorySegment hWnd) {
        try {
            return (MemorySegment) GetDC.handle.invokeExact(hWnd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int releaseDC(MemorySegment hWnd, MemorySegment hDC) {
        try {
            return (int) ReleaseDC.handle.invokeExact(hWnd, hDC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor setWindowPosDescriptor = FunctionDescriptor.ofVoid(C.POINTER, C.POINTER, C.INT, C.INT, C.INT, C.INT, C.INT);
    public static void setWindowPos(MemorySegment hWnd, MemorySegment hWndInsertAfter, int X, int Y, int cx, int cy, int uFlags) {
        try {
            Linker.nativeLinker().downcallHandle(User32.lookup.find("SetWindowPos").orElseThrow(), setWindowPosDescriptor).invokeExact(hWnd, hWndInsertAfter, X, Y, cx, cy, uFlags);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor getWindowTextWDescriptor = FunctionDescriptor.of(C.INT, C.POINTER, C.POINTER, C.INT);
    public static int getWindowTextW(MemorySegment hWnd, MemorySegment lpString, int nMaxCount) {
        try {
            return (int) Linker.nativeLinker().downcallHandle(User32.lookup.find("GetWindowTextW").orElseThrow(), getWindowTextWDescriptor).invokeExact(hWnd, lpString, nMaxCount);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
