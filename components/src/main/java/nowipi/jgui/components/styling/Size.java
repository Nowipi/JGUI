package nowipi.jgui.components.styling;

public final class Size {

    public SizingMode width;
    public SizingMode height;

    public Size(SizingMode width, SizingMode height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Size{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
