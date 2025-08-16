package nowipi.jgui;

public record Rectangle(int left, int right, int top, int bottom) {

    public int width() {
        return right - left;
    }
    public int height() {
        return top - bottom;
    }
}
