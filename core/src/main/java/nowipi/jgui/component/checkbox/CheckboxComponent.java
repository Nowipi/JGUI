package nowipi.jgui.component.checkbox;

import nowipi.jgui.component.Component;
import nowipi.jgui.component.interaction.MouseInteraction;

public abstract class CheckboxComponent implements Component, MouseInteraction {

    private boolean checked;

    public void check() {
        checked = !checked;
    }

    public boolean isChecked() {
        return checked;
    }

    @Override
    public void mouseEnter(int screenX, int screenY) {

    }

    @Override
    public void mouseExit(int screenX, int screenY) {

    }

    @Override
    public void mousePress(int screenX, int screenY) {

    }

    @Override
    public void mouseRelease(int screenX, int screenY) {
        check();
    }
}
