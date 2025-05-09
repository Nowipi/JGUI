package nowipi.jgui.components.styling;

public final class Styling {

    public Border border;
    public Color backgroundColor;

    public Styling(Border border, Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.border = border;
    }

    @Override
    public String toString() {
        return "Styling{" +
                ", border=" + border +
                ", backgroundColor=" + backgroundColor +
                '}';
    }

    public static final class Builder {
        private Border border = Border.newUniform(0);
        private Color backgroundColor = Color.BLACK;

        public Builder border(Border border) {
            this.border = border;
            return this;
        }

        public Builder backgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Styling build() {
            return new Styling(border, backgroundColor);
        }
    }

}
