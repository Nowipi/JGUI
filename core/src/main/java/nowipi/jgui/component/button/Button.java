package nowipi.jgui.component.button;

import nowipi.jgui.component.Component;
import nowipi.jgui.component.interaction.MouseInteraction;

public abstract class Button implements Component, MouseInteraction {

    private boolean hovered;
    private boolean pressed;

    public abstract void click();

    public void press() {
        pressed = true;
    }

    public void release() {
        pressed = false;

        if (hovered) {
            click();
        }
    }

    public void hover() {
        hovered = true;
    }

    public void unHover() {
        hovered = false;
    }

    public boolean isHovered() {
        return hovered;
    }

    public boolean isPressed() {
        return pressed;
    }

    @Override
    public void mouseEnter(int screenX, int screenY) {
        hover();
    }

    @Override
    public void mouseExit(int screenX, int screenY) {
        unHover();
        release();
    }

    @Override
    public void mousePress(int screenX, int screenY) {
        press();
    }

    @Override
    public void mouseRelease(int screenX, int screenY) {
        release();

        if (isHovered()) {
            click();
        }
    }
}
