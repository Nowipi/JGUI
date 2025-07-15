package nowipi.jgui.input.mouse;

public final class MouseData {

    private int x;
    private int y;
    private final boolean[] pressedButtons;

    public MouseData(int y, int x) {
        this.x = x;
        this.y = y;

        pressedButtons = new boolean[Button.values().length];
    }

    public int x() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int y() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPressed(Button button) {
        if (button == null) {
            throw new NullPointerException("button is null");
        }
        return pressedButtons[button.ordinal()];
    }

    public void setPressed(Button button, boolean pressed) {
        if (button == null) {
            throw new NullPointerException("button is null");
        }
        pressedButtons[button.ordinal()] = pressed;
    }
}
