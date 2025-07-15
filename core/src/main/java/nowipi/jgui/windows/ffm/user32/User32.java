package nowipi.jgui.windows.ffm.user32;

import io.github.nowipi.ffm.processor.annotations.Function;
import io.github.nowipi.ffm.processor.annotations.Library;

import java.lang.foreign.MemorySegment;

@Library("user32")
public interface User32 {
    int WS_BORDER = 0x00800000;
    int WS_CAPTION = 0x00C00000;
    int WS_CHILD = 0x40000000;
    int WS_CHILDWINDOW = 0x40000000;
    int WS_CLIPCHILDREN = 0x02000000;
    int WS_CLIPSIBLINGS = 0x04000000;
    int WS_DISABLED = 0x08000000;
    int WS_DLGFRAME = 0x00400000;
    int WS_GROUP = 0x00020000;
    int WS_HSCROLL = 0x00100000;
    int WS_ICONIC = 0x20000000;
    int WS_MAXIMIZE = 0x01000000;
    int WS_MAXIMIZEBOX = 0x00010000;
    int WS_MINIMIZE = 0x20000000;
    int WS_MINIMIZEBOX = 0x00020000;
    int WS_OVERLAPPED = 0x00000000;
    int WS_OVERLAPPEDWINDOW = 0x00CF0000;
    int WS_POPUP = 0x80000000;
    int WS_POPUPWINDOW = 0x80880000;
    int WS_SIZEBOX = 0x00040000;
    int WS_SYSMENU = 0x00080000;
    int WS_TABSTOP = 0x00010000;
    int WS_THICKFRAME = 0x00040000;
    int WS_TILED = 0x00000000;
    int WS_TILEDWINDOW = 0x00CF0000;
    int WS_VISIBLE = 0x10000000;
    int WS_VSCROLL = 0x00200000;
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
    int WM_EXITSIZEMOVE = 0x0232;
    int WH_MOUSE_LL = 14;
    int WM_MOUSEMOVE = 0x0200;
    int WM_LBUTTONDOWN = 0x0201;
    int WM_LBUTTONUP = 0x0202;
    int WM_RBUTTONDOWN = 0x0204;
    int WM_RBUTTONUP = 0x0205;
    int WM_MBUTTONDOWN = 0x0207;
    int WM_MBUTTONUP = 0x0208;
    int WM_XBUTTONDOWN = 0x020B;
    int WM_XBUTTONUP = 0x020C;

    int MK_XBUTTON1 = 0x0020;
    int MK_XBUTTON2 = 0x0040;

    int CS_HREDRAW = 0x001;
    int CS_VREDRAW = 0x002;
    int CS_OWNDC = 0x0020;

    int SWP_NOZORDER = 0x0004;
    int SWP_NOSIZE = 0x0001;

    int INPUT_MOUSE = 0;
    int INPUT_KEYBOARD = 1;
    int INPUT_HARDWARE = 2;

    int MOUSEEVENTF_MOVE = 0x0001;
    int MOUSEEVENTF_LEFTDOWN = 0x0002;
    int MOUSEEVENTF_LEFTUP = 0x0004;
    int MOUSEEVENTF_RIGHTDOWN = 0x0008;
    int MOUSEEVENTF_RIGHTUP = 0x0010;
    int MOUSEEVENTF_MIDDLEDOWN = 0x0020;
    int MOUSEEVENTF_MIDDLEUP = 0x0040;
    int MOUSEEVENTF_XDOWN = 0x0080;
    int MOUSEEVENTF_XUP = 0x0100;
    int MOUSEEVENTF_WHEEL = 0x0800;
    int MOUSEEVENTF_HWHEEL = 0x1000;
    int MOUSEEVENTF_MOVE_NOCOALESCE = 0x2000;
    int MOUSEEVENTF_VIRTUALDESK = 0x4000;
    int MOUSEEVENTF_ABSOLUTE = 0x8000;


    MemorySegment IDC_ARROW = MemorySegment.ofAddress(32512L);

    int WS_EX_NOPARENTNOTIFY = 0x00000004;

    @Function("RegisterClassExW")
    short registerClassEx(MemorySegment unnamedParam1);

    @Function("CreateWindowExW")
    MemorySegment createWindowEx(int dwExStyle, MemorySegment lpClassName, MemorySegment lpWindowName, int dwStyle, int X, int Y, int nWidth, int nHeight, MemorySegment hWndParent,
                                 MemorySegment hMenu, MemorySegment hInstance, MemorySegment lpParam);

    @Function("ShowWindow")
    int showWindow(MemorySegment hWnd, int nCmdShow);

    @Function("PeekMessageW")
    int peekMessage(MemorySegment lpMsg, MemorySegment hWnd, int wMsgFilterMin, int wMsgFilterMax, int wRemoveMsg);

    @Function("TranslateMessage")
    int translateMessage(MemorySegment lpMsg);

    @Function("DispatchMessageW")
    long dispatchMessage(MemorySegment lpMsg);

    @Function("DefWindowProcW")
    long defWindowProc(MemorySegment hWnd, int Msg, long wParam, long lParam);

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
    int getWindowText(MemorySegment hWnd, MemorySegment lpString, int nMaxCount);

    @Function("SetWindowsHookExW")
    MemorySegment setWindowsHookEx(int idHook, MemorySegment lpfn, MemorySegment hmod, int dwThreadId);

    @Function("UnhookWindowsHookEx")
    int unhookWindowsHookEx(MemorySegment hhk);

    @Function("CallNextHookEx")
    MemorySegment callNextHookEx(MemorySegment hhk, int nCode, long wParam, long lParam);

    @Function("SetCursorPos")
    int setCursorPos(int X, int Y);

    @Function("SendInput")
    int sendInput(int cInputs, MemorySegment pInputs, int cbSize);

    @Function("GetWindowRect")
    int getWindowRect(MemorySegment hWnd, MemorySegment lpRect);

    @Function("GetCursorPos")
    int getCursorPos(MemorySegment lpPoint);
}
