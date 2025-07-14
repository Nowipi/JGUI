package nowipi.jgui.component.button;

import nowipi.jgui.component.Component;

public class Button implements Component {


    private ButtonState state;

    public Button() {
        state = ButtonState.NORMAL;
    }

    public void click() {}

    protected void setState(ButtonState state) {
        this.state = state;
    }

    protected ButtonState state() {
        return state;
    }

    public boolean isPressed() {
        return state == ButtonState.PRESSED;
    }

    public boolean isHovered() {
        return state == ButtonState.HOVERED || state == ButtonState.PRESSED;
    }

}
