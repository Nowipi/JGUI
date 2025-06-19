package nowipi.jgui.components.styling;

import nowipi.jgui.components.Component;

/**
 * A layout influences a Component's size and position, or it's children's.
 */
public class Layout {

    public final Size size;

    public Layout(Size size) {
        this.size = size;
    }

    public void layout(Component component) {
        component.width = size.width.calculate(component, null);
        component.height = size.height.calculate(component, null);
        component.x = 0;
        component.y = 0;
    }



    public static class Builder<L extends Layout> {
        protected Size size = new Size(new Fit(), new Fit());

        public Builder<L> size(SizingMode width, SizingMode height) {
            this.size.width = width;
            this.size.height = height;
            return this;
        }

        public Builder<L> size(Size size) {
            this.size = size;
            return this;
        }

        public Builder<L> width(SizingMode width) {
            this.size.width = width;
            return this;
        }

        public Builder<L> height(SizingMode height) {
            this.size.height = height;
            return this;
        }

        @SuppressWarnings("unchecked")
        public L build() {
            return (L)new Layout(size);
        }

    }
}
