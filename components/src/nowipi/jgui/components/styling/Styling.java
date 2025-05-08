package nowipi.jgui.components.styling;

public final class Styling {

    public Padding padding;
    public Size size;
    public Border border;
    public Color backgroundColor;

    public Styling(Padding padding, Size size, Border border, Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.border = border;
        this.padding = padding;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Styling{" +
                "padding=" + padding +
                ", size=" + size +
                ", border=" + border +
                ", backgroundColor=" + backgroundColor +
                '}';
    }

    public static final class Builder {
        private Padding padding = Padding.newUniform(0);
        private Size size = new Size(new Fit(), new Fit());
        private Border border = Border.newUniform(0);
        private Color backgroundColor = Color.BLACK;

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

        public Builder border(Border border) {
            this.border = border;
            return this;
        }

        public Builder backgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Styling build() {
            return new Styling(padding, size, border, backgroundColor);
        }
    }

}
