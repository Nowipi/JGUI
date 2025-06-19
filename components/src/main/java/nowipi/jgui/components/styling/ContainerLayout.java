package nowipi.jgui.components.styling;

import nowipi.jgui.components.Component;
import nowipi.jgui.components.Container;

public final class ContainerLayout extends Layout {

    public final Padding padding;
    public final float childGap;

    public ContainerLayout(Padding padding, float childGap, Size size) {
        super(size);
        this.padding = padding;
        this.childGap = childGap;
    }

    @Override
    public void layout(Component component) {
        super.layout(component);

        setWidth(component);
        //wrapText(component);
        setHeight(component);
        setPosition(component);
    }

    private void setWidth(Component component) {
        //setFitWidth(component);
        //setGrowAndShrinkWidth(component);
    }

    private void setHeight(Component component) {
        //setFitHeight(component);
        //setGrowAndShrinkHeight(component);
    }

    private void setPosition(Component component) {
        if (component instanceof Container container) {
            var layout = container.layout;
            float leftOffset = layout.padding.left;
            for (Component child : container.children()) {
                child.x = container.x + child.x + leftOffset;
                child.y = container.y + child.y;

                leftOffset += child.width + layout.childGap;
            }
        }
    }

    public static class Builder extends Layout.Builder<ContainerLayout> {
        private Padding padding = Padding.newUniform(0);
        private float childGap = 0;

        public Builder childGap(float childGap) {
            this.childGap = childGap;
            return this;
        }

        public Builder padding(Padding padding) {
            this.padding = padding;
            return this;
        }

        public ContainerLayout build() {
            return new ContainerLayout(padding, childGap, size);
        }
    }
}
