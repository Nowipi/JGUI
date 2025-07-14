package nowipi.jgui.input.mouse;

import nowipi.jgui.event.ArrayListEventDispatcher;

public class Mouse extends ArrayListEventDispatcher<MouseEventListener> {

    private float x;
    private float y;
    private final boolean[] pressedButtons;

    public Mouse() {
        pressedButtons = new boolean[Button.values().length];
    }

    public boolean isPressed(Button button) {
        if (button == null)
            throw new NullPointerException("button is null");

        return pressedButtons[button.ordinal()];
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public void setPosition(float x, float y) {
        boolean isSame = this.x == x && this.y == y;
        this.x = x;
        this.y = y;
        if (!isSame) {
            dispatch(l -> l.move(x, y));
        }
    }

    public void press(Button button) {
        if (button == null)
            throw new NullPointerException("button is null");

        if (!isPressed(button)) {
            pressedButtons[button.ordinal()] = true;
            dispatch(l -> l.press(button));
        }

    }

    public void release(Button button) {
        if (button == null)
            throw new NullPointerException("button is null");

        if (isPressed(button)) {
            pressedButtons[button.ordinal()] = false;
            dispatch(l -> l.release(button));
        }
    }
}
