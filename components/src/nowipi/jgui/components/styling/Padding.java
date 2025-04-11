package nowipi.jgui.components.styling;

public final class Padding {

    public float left;
    public float right;
    public float top;
    public float bottom;

    public Padding(float left, float right, float top, float bottom) {
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.top = top;
    }

    public static Padding newUniform(float uniform) {
        return new Padding(uniform, uniform, uniform, uniform);
    }

    public static final class Builder {

        private float left = 0;
        private float right = 0;
        private float top = 0;
        private float bottom = 0;

        public Builder left(float left) {
            this.left = left;
            return this;
        }

        public Builder right(float right) {
            this.right = right;
            return this;
        }

        public Builder top(float top) {
            this.top = top;
            return this;
        }

        public Builder bottom(float bottom) {
            this.bottom = bottom;
            return this;
        }

        public Padding build() {
            return new Padding(left, right, top, bottom);
        }
    }
}
