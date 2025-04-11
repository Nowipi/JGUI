package nowipi.jgui.components.styling;

public final class Styling {

    public Padding padding;
    public Size size;
    public Layout layout;
    public Border border;
    public Object backgroundColor;

    public Styling(Padding padding, Size size, Layout layout, Border border, Object backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.border = border;
        this.layout = layout;
        this.padding = padding;
        this.size = size;
    }

    public Styling() {
        padding = Padding.newUniform(0);
        size = new Size(new Fit(), new Fit());
        layout = new Layout();
        border = Border.newUniform(0);
        backgroundColor = "white";
    }

    public static final class Builder {

        private Styling styling = new Styling();
        private Padding padding = styling.padding;
        private Size size = styling.size;
        private Layout layout = styling.layout;
        private Border border = styling.border;

        public Builder padding(Padding padding) {
            this.padding = padding;
            return this;
        }

        public Builder width(SizingMode widthSizingMode) {
            size.width = widthSizingMode;
            return this;
        }

        public Builder height(SizingMode heightSizingMode) {
            size.height = heightSizingMode;
            return this;
        }

        public Builder fixedSize(int width, int height) {
            return size(new Fixed(width), new Fixed(height));
        }

        public Builder size(SizingMode width, SizingMode height) {
            this.size = new Size(width, height);
            return this;
        }
        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder layout(Layout layout) {
            this.layout = layout;
            return this;
        }

        public Builder border(Border border) {
            this.border = border;
            return this;
        }

        public Styling build() {
            return new Styling(padding, size, layout, border, "white");
        }
    }

    static final class Layout {
        private Object direction;
        private float gap;
        private Alignment alignement;

    }

}
