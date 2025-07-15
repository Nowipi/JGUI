package nowipi.jgui.windows.input;

import nowipi.jgui.event.ArrayListEventDispatcher;
import nowipi.jgui.input.mouse.Button;
import nowipi.jgui.input.mouse.Mouse;
import nowipi.jgui.input.mouse.MouseEventListener;
import nowipi.jgui.windows.ffm.Win32;
import nowipi.jgui.windows.ffm.user32.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static nowipi.jgui.windows.ffm.Win32.user32;
import static nowipi.jgui.windows.ffm.user32.User32.*;

public class Win32Mouse extends ArrayListEventDispatcher<MouseEventListener> implements Mouse, AutoCloseable {


    private final MemorySegment hook;
    private final Arena arena = Arena.ofConfined();
    private final boolean[] pressedButtons;

    @SuppressWarnings("this-escape")
    public Win32Mouse() {
        try {
            MethodHandle hWndProc = MethodHandles.lookup().bind(this, "mouseCallBack",
                    MethodType.methodType(MemorySegment.class,
                            int.class,
                            long.class,
                            long.class
                    ));
            FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);
            hook = user32.setWindowsHookEx(WH_MOUSE_LL, Linker.nativeLinker().upcallStub(hWndProc, descriptor, arena), MemorySegment.NULL, 0);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        pressedButtons = new boolean[Button.values().length];
    }


    private MemorySegment mouseCallBack(int nCode, long wParam, long lParam) {
        if (nCode < 0) {
            return user32.callNextHookEx(MemorySegment.NULL, nCode, wParam, lParam);
        }

        switch ((int) wParam) {
            case WM_LBUTTONDOWN:
                updatePressAndDispatch(Button.LEFT);
                break;
            case WM_LBUTTONUP:
                updateReleaseAndDispatch(Button.LEFT);
                break;
            case WM_RBUTTONDOWN:
                updatePressAndDispatch(Button.RIGHT);
                break;
            case WM_RBUTTONUP:
                updateReleaseAndDispatch(Button.RIGHT);
                break;
            case WM_MBUTTONDOWN:
                updatePressAndDispatch(Button.MIDDLE);
                break;
            case WM_MBUTTONUP:
                updateReleaseAndDispatch(Button.MIDDLE);
                break;
            case WM_XBUTTONDOWN: {
                MemorySegment hook = MSLLHOOKSTRUCT.ofAddress(lParam);
                int highOrder = Win32.hiWord(MSLLHOOKSTRUCT.mouseData(hook));
                switch (highOrder) {
                    case 0x0001:
                        updatePressAndDispatch(Button.X1);
                        break;
                    case 0x0002:
                        updatePressAndDispatch(Button.X2);
                        break;
                }

                break;
            }
            case WM_XBUTTONUP: {
                MemorySegment hook = MSLLHOOKSTRUCT.ofAddress(lParam);
                int highOrder = Win32.hiWord(MSLLHOOKSTRUCT.mouseData(hook));
                switch (highOrder) {
                    case 0x0001:
                        updateReleaseAndDispatch(Button.X1);
                        break;
                    case 0x0002:
                        updateReleaseAndDispatch(Button.X2);
                        break;
                }
                break;
            }
            case WM_MOUSEMOVE:
                MemorySegment hook = MSLLHOOKSTRUCT.ofAddress(lParam);
                dispatch(l -> l.move(MSLLHOOKSTRUCT.x(hook), MSLLHOOKSTRUCT.y(hook)));
                break;
        }
        return user32.callNextHookEx(MemorySegment.NULL, nCode, wParam, lParam);
    }

    @Override
    public boolean isPressed(Button button) {
        return pressedButtons[button.ordinal()];
    }

    @Override
    public int x() {
        try(var arena = Arena.ofConfined()) {
            MemorySegment lpPoint = arena.allocate(Integer.BYTES * 2);
            user32.getCursorPos(lpPoint);
            return lpPoint.get(ValueLayout.JAVA_INT, 0);
        }

    }

    @Override
    public int y() {
        try(var arena = Arena.ofConfined()) {
            MemorySegment lpPoint = arena.allocate(Integer.BYTES * 2);
            user32.getCursorPos(lpPoint);
            return lpPoint.get(ValueLayout.JAVA_INT, 4);
        }
    }

    @Override
    public void setPosition(int x, int y) {
        user32.setCursorPos(x, y);
    }

    private void updatePressAndDispatch(Button button) {
        pressedButtons[button.ordinal()] = true;

        dispatch(l -> l.press(button));
    }

    private void updateReleaseAndDispatch(Button button) {
        pressedButtons[button.ordinal()] = false;

        dispatch(l -> l.release(button));
    }

    @Override
    public void press(Button button) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment input = INPUT.allocate(arena);
            input.fill((byte) 0); // Zero out the entire struct — CRUCIAL

            INPUT.setType(input, INPUT_MOUSE);
            MOUSEINPUT.setDwFlags(INPUT.mi(input), buttonToPressedMouseEventFlag(button));


            user32.sendInput(1, input, (int) INPUT.BYTES);

            updatePressAndDispatch(button);
        }
    }

    private static int buttonToPressedMouseEventFlag(Button button) {
        return switch (button) {
            case LEFT -> MOUSEEVENTF_LEFTDOWN;
            case RIGHT -> MOUSEEVENTF_RIGHTDOWN;
            case MIDDLE -> MOUSEEVENTF_MIDDLEDOWN;
            case X1, X2 -> MOUSEEVENTF_XDOWN;
        };
    }

    @Override
    public void release(Button button) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment input = INPUT.allocate(arena);

            INPUT.setType(input, INPUT_MOUSE);
            MOUSEINPUT.setDwFlags(INPUT.mi(input), buttonToReleasedMouseEventFlag(button));

            user32.sendInput(1, input, (int) INPUT.BYTES);

            updateReleaseAndDispatch(button);
        }
    }

    private static int buttonToReleasedMouseEventFlag(Button button) {
        return switch (button) {
            case LEFT -> MOUSEEVENTF_LEFTUP;
            case RIGHT -> MOUSEEVENTF_RIGHTUP;
            case MIDDLE -> MOUSEEVENTF_MIDDLEUP;
            case X1, X2 -> MOUSEEVENTF_XUP;
        };
    }


    @Override
    public void close() {
        user32.unhookWindowsHookEx(hook);
        arena.close();
    }
}