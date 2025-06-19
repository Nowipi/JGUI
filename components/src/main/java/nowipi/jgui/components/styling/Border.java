package nowipi.jgui.components.styling;

public final class Border {

    public float left;
    public float right;
    public float top;
    public float bottom;

    public Border(float left, float right, float top, float bottom) {
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.top = top;
    }

    public static Border newUniform(int uniform) {
        return new Border(uniform, uniform, uniform, uniform);
    }

    @Override
    public String toString() {
        return "Border{" +
                "left=" + left +
                ", right=" + right +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
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

        public Border build() {
            return new Border(left, right, top, bottom);
        }
    }
}
