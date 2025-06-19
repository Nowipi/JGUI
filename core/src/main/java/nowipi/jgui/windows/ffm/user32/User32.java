package nowipi.jgui.windows.ffm.user32;

import io.github.nowipi.ffm.processor.annotations.Function;
import io.github.nowipi.ffm.processor.annotations.Library;

import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;

@Library("user32")
public interface User32 {
    int WS_BORDER = 0x00800000;
    int WS_CAPTION = 0x00C00000;
    int WS_CHILD = 0x40000000;
    int WS_CHILDWINDOW = 0x40000000;
    int WS_CLIPCHILDREN	= 0x02000000;
    int WS_CLIPSIBLINGS	= 0x04000000;
    int WS_DISABLED	= 0x08000000;
    int WS_DLGFRAME	= 0x00400000;
    int WS_GROUP	= 0x00020000;
    int WS_HSCROLL	= 0x00100000;
    int WS_ICONIC	= 0x20000000;
    int WS_MAXIMIZE	= 0x01000000;
    int WS_MAXIMIZEBOX	= 0x00010000;
    int WS_MINIMIZE	= 0x20000000;
    int WS_MINIMIZEBOX	= 0x00020000;
    int WS_OVERLAPPED	= 0x00000000;
    int WS_OVERLAPPEDWINDOW	= 0x00CF0000;
    int WS_POPUP	= 0x80000000;
    int WS_POPUPWINDOW	= 0x80880000;
    int WS_SIZEBOX	= 0x00040000;
    int WS_SYSMENU	= 0x00080000;
    int WS_TABSTOP	= 0x00010000;
    int WS_THICKFRAME	= 0x00040000;
    int WS_TILED	= 0x00000000;
    int WS_TILEDWINDOW	= 0x00CF0000;
    int WS_VISIBLE	= 0x10000000;
    int WS_VSCROLL	= 0x00200000;
    int CW_USEDEFAULT = 0x80000000;
    int SW_SHOW = 5;
    int PM_REMOVE = 0x0001;

    int WM_CREATE = 0x0001;
    int WM_DESTROY = 0x0002;
    int WM_MOVE = 0x0003;
    int WM_SIZE = 0x0005;
    int WM_PAINT = 0x000F;
    int WM_KEYDOWN = 0x0100;
    int WM_KEYUP = 0x0101;
    int WM_SIZING = 0x0214;
    int WM_ENTERSIZEMOVE = 0x0231;
    int WM_EXITSIZEMOVE  = 0x0232;

    int CS_HREDRAW = 0x001;
    int CS_VREDRAW = 0x002;
    int CS_OWNDC = 0x0020;

    int SWP_NOZORDER = 0x0004;
    int SWP_NOSIZE = 0x0001;



    MemorySegment IDC_ARROW = MemorySegment.ofAddress(32512L);

    int WS_EX_NOPARENTNOTIFY = 0x00000004;

    @Function("RegisterClassW")
    short registerClassW(MemorySegment wndClass);

    @Function("CreateWindowExW")
    MemorySegment createWindowExW(int dwExStyle, MemorySegment lpClassName, MemorySegment lpWindowName, int dwStyle, int X, int Y, int nWidth, int nHeight, MemorySegment hWndParent,
                                                MemorySegment hMenu, MemorySegment hInstance, MemorySegment lpParam);

    @Function("ShowWindow")
    int showWindow(MemorySegment hWnd, int nCmdShow);

    @Function("PeekMessageW")
    int peekMessageW(MemorySegment lpMsg, MemorySegment hWnd, int wMsgFilterMin, int wMsgFilterMax, int wRemoveMsg);

    @Function("TranslateMessage")
    int translateMessage(MemorySegment lpMsg);

    @Function("DispatchMessageW")
    long dispatchMessageW(MemorySegment lpMsg);

    @Function("DefWindowProcW")
    long defWindowProcW(MemorySegment hWnd, int Msg, long wParam, long lParam);

    @Function("IsWindowVisible")
    boolean isWindowVisible(MemorySegment hWnd);

    @Function("ValidateRect")
    int validateRect(MemorySegment hWnd, MemorySegment lpRect);

    @Function("LoadCursorA")
    MemorySegment loadCursorA(MemorySegment hInstance, MemorySegment lpCursorName);

    @Function("DestroyWindow")
    int destroyWindow(MemorySegment hWnd);

    @Function("GetDC")
    MemorySegment getDC(MemorySegment hWnd);

    @Function("ReleaseDC")
    int releaseDC(MemorySegment hWnd, MemorySegment hDC);

    @Function("SetWindowPos")
    void setWindowPos(MemorySegment hWnd, MemorySegment hWndInsertAfter, int X, int Y, int cx, int cy, int uFlags);

    @Function("GetWindowTextW")
    int getWindowTextW(MemorySegment hWnd, MemorySegment lpString, int nMaxCount);
}
