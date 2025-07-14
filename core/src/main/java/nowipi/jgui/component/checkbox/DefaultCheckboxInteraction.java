package nowipi.jgui.component.checkbox;

import nowipi.jgui.component.interaction.MouseInteraction;

public class DefaultCheckboxInteraction implements MouseInteraction {

    private final Checkbox checkbox;

    public DefaultCheckboxInteraction(Checkbox checkbox) {
        this.checkbox = checkbox;
    }

    @Override
    public void mouseEnter() {

    }

    @Override
    public void mouseExit() {

    }

    @Override
    public void mousePress() {

    }

    @Override
    public void mouseRelease() {
        checkbox.check();
    }
}
