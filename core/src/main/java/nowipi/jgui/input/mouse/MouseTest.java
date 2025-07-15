package nowipi.jgui.input.mouse;

import nowipi.jgui.window.Window;
import nowipi.jgui.windows.input.Win32Mouse;

final class MouseTest {
    public static void main(String[] args) {
        Window window = Window.createWindowed("test", 10, 10);
        window.show();

        Win32Mouse mouse = new Win32Mouse();

        mouse.addListener(new MouseEventListener() {
            @Override
            public void press(Button button) {

            }

            @Override
            public void release(Button button) {
                if (button == Button.X1) {
                    drawSmiley(mouse);
                }
            }

            @Override
            public void move(float x, float y) {

            }
        });

        while (!window.shouldClose()) {
            window.pollEvents();
            System.out.println(mouse.x() + " " + mouse.y());
        }

        mouse.close();
    }

    private static void drawCircle(Mouse mouse, float centerX, float centerY, float radius) {


        double startX = Math.sin(0) * radius + centerX;
        double startY = Math.cos(0) * radius + centerY;


        mouse.setPosition((int) startX, (int) startY);
        mouse.press(Button.LEFT);

        for(double t = Math.PI * 0.5; t <= Math.PI; t+=0.0001) {
            double x = Math.sin(t) * radius + centerX;
            double y = Math.cos(t) * radius + centerY;
            mouse.setPosition((int) x, (int) y);
        }
        mouse.release(Button.LEFT);

    }

    private static void drawSmiley(Mouse mouse) {
        final int topLeftX = mouse.x();
        final int topLeftY = mouse.y();
        drawLine(mouse, topLeftX, topLeftY, topLeftX, topLeftY - 100);

        drawLine(mouse, topLeftX + 200, topLeftY, topLeftX + 200, topLeftY - 100);

        drawCircle(mouse, topLeftX + 100, topLeftY - 100, 50);
    }

    private static void drawLine(Mouse mouse, int fromX, int fromY, int toX, int toY) {
        mouse.setPosition(fromX, fromY);
        mouse.press(Button.LEFT);
        mouse.setPosition(toX, toY);
        mouse.release(Button.LEFT);
    }
}
