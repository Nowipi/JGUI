package nowipi.jgui.component.button;

import nowipi.jgui.component.interaction.MouseInteraction;

public class DefaultButtonInteraction implements MouseInteraction {

    private final Button button;

    public DefaultButtonInteraction(Button button) {
        this.button = button;
    }

    @Override
    public void mouseEnter() {
        button.setState(ButtonState.HOVERED);
    }

    @Override
    public void mouseExit() {
        button.setState(ButtonState.NORMAL);
    }

    @Override
    public void mousePress() {
        button.setState(ButtonState.PRESSED);
    }

    @Override
    public void mouseRelease() {
        button.setState(ButtonState.HOVERED);
        button.click();
    }
}
