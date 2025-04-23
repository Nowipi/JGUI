package nowipi.jgui.components.styling;

import nowipi.jgui.components.Component;

public final class Fixed implements SizingMode {

    private float size;

    public Fixed(float size) {
        this.size = size;
    }

    @Override
    public float size(Component component) {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
