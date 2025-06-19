package nowipi.jgui.components.styling;

import nowipi.jgui.components.Component;

public final class Fixed implements SizingMode {

    private float size;

    public Fixed(float size) {
        this.size = size;
    }

    @Override
    public float calculate(Component parent, Component child) {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
