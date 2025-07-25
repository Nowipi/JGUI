package nowipi.jgui.windows.input;

import nowipi.jgui.event.ArrayListEventDispatcher;
import nowipi.jgui.input.keyboard.Key;
import nowipi.jgui.input.keyboard.Keyboard;
import nowipi.jgui.input.keyboard.KeyboardEventListener;
import nowipi.jgui.windows.ffm.user32.KBDLLHOOKSTRUCT;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.HashSet;
import java.util.Set;

import static nowipi.jgui.windows.ffm.Win32.user32;
import static nowipi.jgui.windows.ffm.user32.User32.*;

public class Win32Keyboard extends ArrayListEventDispatcher<KeyboardEventListener> implements Keyboard, AutoCloseable {

    //TODO ALT and FN don't register

    private static final int INITIAL_CAPACITY_BASED_ON_ROLL_OVER = 6;

    private final Arena arena;
    private MemorySegment hook;
    private final Set<Key> pressedKeys;

    @SuppressWarnings("this-escape")
    public Win32Keyboard() {
        arena = Arena.ofConfined();
        pressedKeys = new HashSet<>(INITIAL_CAPACITY_BASED_ON_ROLL_OVER);
        try {
            MethodHandle hWndProc = MethodHandles.lookup().bind(this, "keyCallback",
                    MethodType.methodType(MemorySegment.class,
                            int.class,
                            long.class,
                            long.class
                    ));
            FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);
            hook = user32.setWindowsHookEx(WH_KEYBOARD_LL, Linker.nativeLinker().upcallStub(hWndProc, descriptor, arena), MemorySegment.NULL, 0);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private MemorySegment keyCallback(int nCode, long wParam, long lParam) {
        if (nCode < 0) {
            return user32.callNextHookEx(MemorySegment.NULL, nCode, wParam, lParam);
        }

        switch ((int) wParam) {
            case WM_KEYDOWN: {
                MemorySegment struct = KBDLLHOOKSTRUCT.ofAddress(lParam);
                updatePressAndDispatch(win32VirtualKeyToKey(KBDLLHOOKSTRUCT.vkCode(struct)));
            } break;
            case WM_KEYUP: {
                MemorySegment struct = KBDLLHOOKSTRUCT.ofAddress(lParam);
                updateReleaseAndDispatch(win32VirtualKeyToKey(KBDLLHOOKSTRUCT.vkCode(struct)));
            } break;
        }

        return user32.callNextHookEx(MemorySegment.NULL, nCode, wParam, lParam);
    }

    private void updatePressAndDispatch(Key key) {
        if (pressedKeys.contains(key))
            return;

        pressedKeys.add(key);
        dispatch(l -> l.press(key));
    }

    private void updateReleaseAndDispatch(Key key) {
        if (!pressedKeys.contains(key))
            return;

        pressedKeys.remove(key);
        dispatch(l -> l.release(key));
    }

    @Override
    public void press(Key key) {

        /*
        TODO send key press to OS
        try (var arena = Arena.ofConfined()) {
        MemorySegment input = INPUT.allocate(arena);
        input.fill((byte) 0); // Zero out the entire struct — CRUCIAL

        INPUT.setType(input, INPUT_KEYBOARD);
        KEYBOARDINPUT.setDwFlags(INPUT.ki(input), buttonToPressedMouseEventFlag(button));


        user32.sendInput(1, input, (int) INPUT.BYTES);}*/

        updatePressAndDispatch(key);
    }

    @Override
    public void release(Key key) {
        //TODO send key press to OS
        updateReleaseAndDispatch(key);
    }

    @Override
    public boolean isPressed(Key key) {
        return pressedKeys.contains(key);
    }

    @Override
    public void close() {
        user32.unhookWindowsHookEx(hook);
        arena.close();
    }

    public static Key win32VirtualKeyToKey(int vk) {
        return switch (vk) {
            case VK_BACK -> Key.BACK;
            case VK_TAB -> Key.TAB;
            case VK_CLEAR -> Key.CLEAR;
            case VK_RETURN -> Key.ENTER;
            case VK_SHIFT -> Key.SHIFT;
            case VK_CONTROL -> Key.CONTROL;
            case VK_MENU -> Key.MENU;
            case VK_PAUSE -> Key.PAUSE;
            case VK_CAPITAL -> Key.CAPITAL;
            /*case VK_KANA -> Key.KANA; TODO
            case VK_HANGUL -> Key.HANGUL;*/
            case VK_IME_ON -> Key.IME_ON;
            case VK_JUNJA -> Key.JUNJA;
            case VK_FINAL -> Key.FINAL;
            /*case VK_HANJA -> Key.HANJA; TODO
            case VK_KANJI -> Key.KANJI;*/
            case VK_IME_OFF -> Key.IME_OFF;
            case VK_ESCAPE -> Key.ESCAPE;
            case VK_CONVERT -> Key.CONVERT;
            case VK_NONCONVERT -> Key.NONCONVERT;
            case VK_ACCEPT -> Key.ACCEPT;
            case VK_MODECHANGE -> Key.MODECHANGE;
            case VK_SPACE -> Key.SPACE;
            case VK_PRIOR -> Key.PRIOR;
            case VK_NEXT -> Key.NEXT;
            case VK_END -> Key.END;
            case VK_HOME -> Key.HOME;
            case VK_LEFT -> Key.LEFT;
            case VK_UP -> Key.UP;
            case VK_RIGHT -> Key.RIGHT;
            case VK_DOWN -> Key.DOWN;
            case VK_SELECT -> Key.SELECT;
            case VK_PRINT -> Key.PRINT;
            case VK_EXECUTE -> Key.EXECUTE;
            case VK_SNAPSHOT -> Key.SNAPSHOT;
            case VK_INSERT -> Key.INSERT;
            case VK_DELETE -> Key.DELETE;
            case VK_HELP -> Key.HELP;
            case VK_ZERO -> Key.ZERO;
            case VK_ONE -> Key.ONE;
            case VK_TWO -> Key.TWO;
            case VK_THREE -> Key.THREE;
            case VK_FOUR -> Key.FOUR;
            case VK_FIVE -> Key.FIVE;
            case VK_SIX -> Key.SIX;
            case VK_SEVEN -> Key.SEVEN;
            case VK_EIGHT -> Key.EIGHT;
            case VK_NINE -> Key.NINE;
            case VK_A -> Key.A;
            case VK_B -> Key.B;
            case VK_C -> Key.C;
            case VK_D -> Key.D;
            case VK_E -> Key.E;
            case VK_F -> Key.F;
            case VK_G -> Key.G;
            case VK_H -> Key.H;
            case VK_I -> Key.I;
            case VK_J -> Key.J;
            case VK_K -> Key.K;
            case VK_L -> Key.L;
            case VK_M -> Key.M;
            case VK_N -> Key.N;
            case VK_O -> Key.O;
            case VK_P -> Key.P;
            case VK_Q -> Key.Q;
            case VK_R -> Key.R;
            case VK_S -> Key.S;
            case VK_T -> Key.T;
            case VK_U -> Key.U;
            case VK_V -> Key.V;
            case VK_W -> Key.W;
            case VK_X -> Key.X;
            case VK_Y -> Key.Y;
            case VK_Z -> Key.Z;
            case VK_LWIN -> Key.LWIN;
            case VK_RWIN -> Key.RWIN;
            case VK_APPS -> Key.APPS;
            case VK_SLEEP -> Key.SLEEP;
            case VK_NUMPAD0 -> Key.NUMPAD0;
            case VK_NUMPAD1 -> Key.NUMPAD1;
            case VK_NUMPAD2 -> Key.NUMPAD2;
            case VK_NUMPAD3 -> Key.NUMPAD3;
            case VK_NUMPAD4 -> Key.NUMPAD4;
            case VK_NUMPAD5 -> Key.NUMPAD5;
            case VK_NUMPAD6 -> Key.NUMPAD6;
            case VK_NUMPAD7 -> Key.NUMPAD7;
            case VK_NUMPAD8 -> Key.NUMPAD8;
            case VK_NUMPAD9 -> Key.NUMPAD9;
            case VK_MULTIPLY -> Key.MULTIPLY;
            case VK_ADD -> Key.ADD;
            case VK_SEPARATOR -> Key.SEPARATOR;
            case VK_SUBTRACT -> Key.SUBTRACT;
            case VK_DECIMAL -> Key.DECIMAL;
            case VK_DIVIDE -> Key.DIVIDE;
            case VK_F1 -> Key.F1;
            case VK_F2 -> Key.F2;
            case VK_F3 -> Key.F3;
            case VK_F4 -> Key.F4;
            case VK_F5 -> Key.F5;
            case VK_F6 -> Key.F6;
            case VK_F7 -> Key.F7;
            case VK_F8 -> Key.F8;
            case VK_F9 -> Key.F9;
            case VK_F10 -> Key.F10;
            case VK_F11 -> Key.F11;
            case VK_F12 -> Key.F12;
            case VK_F13 -> Key.F13;
            case VK_F14 -> Key.F14;
            case VK_F15 -> Key.F15;
            case VK_F16 -> Key.F16;
            case VK_F17 -> Key.F17;
            case VK_F18 -> Key.F18;
            case VK_F19 -> Key.F19;
            case VK_F20 -> Key.F20;
            case VK_F21 -> Key.F21;
            case VK_F22 -> Key.F22;
            case VK_F23 -> Key.F23;
            case VK_F24 -> Key.F24;
            case VK_NUMLOCK -> Key.NUMLOCK;
            case VK_SCROLL -> Key.SCROLL;
            case VK_LSHIFT -> Key.LSHIFT;
            case VK_RSHIFT -> Key.RSHIFT;
            case VK_LCONTROL -> Key.LCONTROL;
            case VK_RCONTROL -> Key.RCONTROL;
            case VK_LMENU -> Key.LMENU;
            case VK_RMENU -> Key.RMENU;
            case VK_BROWSER_BACK -> Key.BROWSER_BACK;
            case VK_BROWSER_FORWARD -> Key.BROWSER_FORWARD;
            case VK_BROWSER_REFRESH -> Key.BROWSER_REFRESH;
            case VK_BROWSER_STOP -> Key.BROWSER_STOP;
            case VK_BROWSER_SEARCH -> Key.BROWSER_SEARCH;
            case VK_BROWSER_FAVORITES -> Key.BROWSER_FAVORITES;
            case VK_BROWSER_HOME -> Key.BROWSER_HOME;
            case VK_VOLUME_MUTE -> Key.VOLUME_MUTE;
            case VK_VOLUME_DOWN -> Key.VOLUME_DOWN;
            case VK_VOLUME_UP -> Key.VOLUME_UP;
            case VK_MEDIA_NEXT_TRACK -> Key.MEDIA_NEXT_TRACK;
            case VK_MEDIA_PREV_TRACK -> Key.MEDIA_PREV_TRACK;
            case VK_MEDIA_STOP -> Key.MEDIA_STOP;
            case VK_MEDIA_PLAY_PAUSE -> Key.MEDIA_PLAY_PAUSE;
            case VK_LAUNCH_MAIL -> Key.LAUNCH_MAIL;
            case VK_LAUNCH_MEDIA_SELECT -> Key.LAUNCH_MEDIA_SELECT;
            case VK_LAUNCH_APP1 -> Key.LAUNCH_APP1;
            case VK_LAUNCH_APP2 -> Key.LAUNCH_APP2;
            case VK_OEM_1 -> Key.OEM_1;
            case VK_OEM_PLUS -> Key.OEM_PLUS;
            case VK_OEM_COMMA -> Key.OEM_COMMA;
            case VK_OEM_MINUS -> Key.OEM_MINUS;
            case VK_OEM_PERIOD -> Key.OEM_PERIOD;
            case VK_OEM_2 -> Key.OEM_2;
            case VK_OEM_3 -> Key.OEM_3;
            case VK_OEM_4 -> Key.OEM_4;
            case VK_OEM_5 -> Key.OEM_5;
            case VK_OEM_6 -> Key.OEM_6;
            case VK_OEM_7 -> Key.OEM_7;
            case VK_OEM_8 -> Key.OEM_8;
            case VK_OEM_102 -> Key.OEM_102;
            case VK_PROCESSKEY -> Key.PROCESSKEY;
            case VK_PACKET -> Key.PACKET;
            case VK_ATTN -> Key.ATTN;
            case VK_CRSEL -> Key.CRSEL;
            case VK_EXSEL -> Key.EXSEL;
            case VK_EREOF -> Key.EREOF;
            case VK_PLAY -> Key.PLAY;
            case VK_ZOOM -> Key.ZOOM;
            case VK_NONAME -> Key.NONAME;
            case VK_PA1 -> Key.PA1;
            case VK_OEM_CLEAR -> Key.OEM_CLEAR;
            default -> throw new IllegalArgumentException("Unsupported virtual key: " + vk);
        };
    }
}
