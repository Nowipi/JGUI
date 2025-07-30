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
    int WH_KEYBOARD_LL = 13;
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
    int WM_ERASEBKGND = 0x0014;

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

    int VK_LBUTTON = 0x01;
    int VK_RBUTTON = 0x02;
    int VK_CANCEL = 0x03;
    int VK_MBUTTON = 0x04;
    int VK_XBUTTON1 = 0x05;
    int VK_XBUTTON2 = 0x06;
    int VK_BACK = 0x08;
    int VK_TAB = 0x09;
    int VK_CLEAR = 0x0C;
    int VK_RETURN = 0x0D;
    int VK_SHIFT = 0x10;
    int VK_CONTROL = 0x11;
    int VK_MENU = 0x12;
    int VK_PAUSE = 0x13;
    int VK_CAPITAL = 0x14;
    int VK_KANA = 0x15;
    int VK_HANGUL = 0x15;
    int VK_IME_ON = 0x16;
    int VK_JUNJA = 0x17;
    int VK_FINAL = 0x18;
    int VK_HANJA = 0x19;
    int VK_KANJI = 0x19;
    int VK_IME_OFF = 0x1A;
    int VK_ESCAPE = 0x1B;
    int VK_CONVERT = 0x1C;
    int VK_NONCONVERT = 0x1D;
    int VK_ACCEPT = 0x1E;
    int VK_MODECHANGE = 0x1F;
    int VK_SPACE = 0x20;
    int VK_PRIOR = 0x21;
    int VK_NEXT = 0x22;
    int VK_END = 0x23;
    int VK_HOME = 0x24;
    int VK_LEFT = 0x25;
    int VK_UP = 0x26;
    int VK_RIGHT = 0x27;
    int VK_DOWN = 0x28;
    int VK_SELECT = 0x29;
    int VK_PRINT = 0x2A;
    int VK_EXECUTE = 0x2B;
    int VK_SNAPSHOT = 0x2C;
    int VK_INSERT = 0x2D;
    int VK_DELETE = 0x2E;
    int VK_HELP = 0x2F;
    int VK_ZERO = 0x30;
    int VK_ONE = 0x31;
    int VK_TWO = 0x32;
    int VK_THREE = 0x33;
    int VK_FOUR = 0x34;
    int VK_FIVE = 0x35;
    int VK_SIX = 0x36;
    int VK_SEVEN = 0x37;
    int VK_EIGHT = 0x38;
    int VK_NINE = 0x39;
    int VK_A = 0x41;
    int VK_B = 0x42;
    int VK_C = 0x43;
    int VK_D = 0x44;
    int VK_E = 0x45;
    int VK_F = 0x46;
    int VK_G = 0x47;
    int VK_H = 0x48;
    int VK_I = 0x49;
    int VK_J = 0x4A;
    int VK_K = 0x4B;
    int VK_L = 0x4C;
    int VK_M = 0x4D;
    int VK_N = 0x4E;
    int VK_O = 0x4F;
    int VK_P = 0x50;
    int VK_Q = 0x51;
    int VK_R = 0x52;
    int VK_S = 0x53;
    int VK_T = 0x54;
    int VK_U = 0x55;
    int VK_V = 0x56;
    int VK_W = 0x57;
    int VK_X = 0x58;
    int VK_Y = 0x59;
    int VK_Z = 0x5A;
    int VK_LWIN = 0x5B;
    int VK_RWIN = 0x5C;
    int VK_APPS = 0x5D;
    int VK_SLEEP = 0x5F;
    int VK_NUMPAD0 = 0x60;
    int VK_NUMPAD1 = 0x61;
    int VK_NUMPAD2 = 0x62;
    int VK_NUMPAD3 = 0x63;
    int VK_NUMPAD4 = 0x64;
    int VK_NUMPAD5 = 0x65;
    int VK_NUMPAD6 = 0x66;
    int VK_NUMPAD7 = 0x67;
    int VK_NUMPAD8 = 0x68;
    int VK_NUMPAD9 = 0x69;
    int VK_MULTIPLY = 0x6A;
    int VK_ADD = 0x6B;
    int VK_SEPARATOR = 0x6C;
    int VK_SUBTRACT = 0x6D;
    int VK_DECIMAL = 0x6E;
    int VK_DIVIDE = 0x6F;
    int VK_F1 = 0x70;
    int VK_F2 = 0x71;
    int VK_F3 = 0x72;
    int VK_F4 = 0x73;
    int VK_F5 = 0x74;
    int VK_F6 = 0x75;
    int VK_F7 = 0x76;
    int VK_F8 = 0x77;
    int VK_F9 = 0x78;
    int VK_F10 = 0x79;
    int VK_F11 = 0x7A;
    int VK_F12 = 0x7B;
    int VK_F13 = 0x7C;
    int VK_F14 = 0x7D;
    int VK_F15 = 0x7E;
    int VK_F16 = 0x7F;
    int VK_F17 = 0x80;
    int VK_F18 = 0x81;
    int VK_F19 = 0x82;
    int VK_F20 = 0x83;
    int VK_F21 = 0x84;
    int VK_F22 = 0x85;
    int VK_F23 = 0x86;
    int VK_F24 = 0x87;
    int VK_NUMLOCK = 0x90;
    int VK_SCROLL = 0x91;
    int VK_LSHIFT = 0xA0;
    int VK_RSHIFT = 0xA1;
    int VK_LCONTROL = 0xA2;
    int VK_RCONTROL = 0xA3;
    int VK_LMENU = 0xA4;
    int VK_RMENU = 0xA5;
    int VK_BROWSER_BACK = 0xA6;
    int VK_BROWSER_FORWARD = 0xA7;
    int VK_BROWSER_REFRESH = 0xA8;
    int VK_BROWSER_STOP = 0xA9;
    int VK_BROWSER_SEARCH = 0xAA;
    int VK_BROWSER_FAVORITES = 0xAB;
    int VK_BROWSER_HOME = 0xAC;
    int VK_VOLUME_MUTE = 0xAD;
    int VK_VOLUME_DOWN = 0xAE;
    int VK_VOLUME_UP = 0xAF;
    int VK_MEDIA_NEXT_TRACK = 0xB0;
    int VK_MEDIA_PREV_TRACK = 0xB1;
    int VK_MEDIA_STOP = 0xB2;
    int VK_MEDIA_PLAY_PAUSE = 0xB3;
    int VK_LAUNCH_MAIL = 0xB4;
    int VK_LAUNCH_MEDIA_SELECT = 0xB5;
    int VK_LAUNCH_APP1 = 0xB6;
    int VK_LAUNCH_APP2 = 0xB7;
    int VK_OEM_1 = 0xBA;
    int VK_OEM_PLUS = 0xBB;
    int VK_OEM_COMMA = 0xBC;
    int VK_OEM_MINUS = 0xBD;
    int VK_OEM_PERIOD = 0xBE;
    int VK_OEM_2 = 0xBF;
    int VK_OEM_3 = 0xC0;
    int VK_OEM_4 = 0xDB;
    int VK_OEM_5 = 0xDC;
    int VK_OEM_6 = 0xDD;
    int VK_OEM_7 = 0xDE;
    int VK_OEM_8 = 0xDF;
    int VK_OEM_102 = 0xE2;
    int VK_PROCESSKEY = 0xE5;
    int VK_PACKET = 0xE6;
    int VK_ATTN = 0xE7;
    int VK_CRSEL = 0xF6;
    int VK_EXSEL = 0xF7;
    int VK_EREOF = 0xF8;
    int VK_PLAY = 0xF9;
    int VK_ZOOM = 0xFA;
    int VK_NONAME = 0xFB;
    int VK_PA1 = 0xFC;
    int VK_OEM_CLEAR = 0xFD;


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

    @Function("UpdateWindow")
    int updateWindow(MemorySegment hWnd);

    @Function("BeginPaint")
    MemorySegment beginPaint(MemorySegment hWnd, MemorySegment lpPaint);

    @Function("EndPaint")
    int endPaint(MemorySegment hWnd, MemorySegment lpPaint);
}
