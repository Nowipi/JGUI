package nowipi.jgui.windows.input;

import nowipi.jgui.input.mouse.Button;
import nowipi.jgui.input.mouse.Mouse;
import nowipi.jgui.input.mouse.MouseEventListener;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.jgui.windows.ffm.Win32;
import nowipi.jgui.windows.ffm.user32.MSLLHOOKSTRUCT;
import nowipi.jgui.windows.ffm.user32.User32;
import nowipi.jgui.windows.ffm.user32.User32Impl;
import nowipi.jgui.windows.window.Win32Window;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static nowipi.jgui.windows.ffm.user32.User32.*;

class Win32Mouse extends Mouse {


    private static final User32 user32 = new User32Impl();


    public Win32Mouse() {
        try {
            MethodHandle hWndProc = MethodHandles.lookup().bind(this, "mouseCallBack",
                    MethodType.methodType(MemorySegment.class,
                            int.class,
                            long.class,
                            long.class
                    ));
            FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);
            user32.setWindowsHookEx(WH_MOUSE_LL, Linker.nativeLinker().upcallStub(hWndProc, descriptor, Win32.arena), MemorySegment.NULL, 0);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    private MemorySegment mouseCallBack(int nCode, long wParam, long lParam) {
        if (nCode < 0) {
            return user32.callNextHookEx(MemorySegment.NULL, nCode, wParam, lParam);
        }

        switch ((int) wParam) {
            case WM_LBUTTONDOWN:
                press(Button.LEFT);
                break;
            case WM_LBUTTONUP:
                release(Button.LEFT);
                break;
            case WM_RBUTTONDOWN:
                press(Button.RIGHT);
                break;
            case WM_RBUTTONUP:
                release(Button.RIGHT);
                break;
            case WM_MBUTTONDOWN:
                press(Button.MIDDLE);
                break;
            case WM_MBUTTONUP:
                release(Button.MIDDLE);
                break;
            case WM_XBUTTONDOWN: {
                MemorySegment hook = MSLLHOOKSTRUCT.ofAddress(lParam);
                int highOrder = Win32.hiWord(MSLLHOOKSTRUCT.mouseData(hook));
                switch (highOrder) {
                    case 0x0001:
                        press(Button.X1);
                        break;
                    case 0x0002:
                        press(Button.X2);
                        break;
                }

                break;
            }
            case WM_XBUTTONUP: {
                MemorySegment hook = MSLLHOOKSTRUCT.ofAddress(lParam);
                int highOrder = Win32.hiWord(MSLLHOOKSTRUCT.mouseData(hook));
                switch (highOrder) {
                    case 0x0001:
                        release(Button.X1);
                        break;
                    case 0x0002:
                        release(Button.X2);
                        break;
                }
                break;
            }
            case WM_MOUSEMOVE:
                MemorySegment hook = MSLLHOOKSTRUCT.ofAddress(lParam);
                setPosition(MSLLHOOKSTRUCT.x(hook), MSLLHOOKSTRUCT.y(hook));
                break;
        }
        return user32.callNextHookEx(MemorySegment.NULL, nCode, wParam, lParam);
    }

    public static void main(String[] args) {
        Window window = Window.createWindowed("Hi", 1080, 720);

        window.show();

        Mouse mouse = new Win32Mouse();

        mouse.addListener(new MouseEventListener() {
            @Override
            public void press(Button button) {
                System.out.printf("press button %s\n", button);
            }

            @Override
            public void release(Button button) {
                System.out.printf("released button %s\n", button);
            }

            @Override
            public void move(float x, float y) {
                System.out.printf("move x=%f y=%f\n", x, y);
            }
        });

        while (!window.shouldClose()) {
            window.pollEvents();
        }

    }

}
