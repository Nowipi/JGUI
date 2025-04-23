package nowipi.jgui.components.styling;

public final class Layout {
    public Object direction;
    public float gap;
    public Alignment alignement;

    public Layout(Object direction, float gap, Alignment alignement) {
        this.direction = direction;
        this.gap = gap;
        this.alignement = alignement;
    }

    public static final class Builder {
        private Object direction;
        private float gap = 0;
        private Alignment alignement = new Alignment(Position.LEFT, Position.TOP);

        public Builder gap(float gap) {
            this.gap = gap;
            return this;
        }

        public Layout build() {
            return new Layout(direction, gap, alignement);
        }
    }
}
