package nowipi.jgui.components.styling;

/**
 * 0-255 RGBA Color
 */
public final class Color {

    public static final Color BLACK = new Color(0, 0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255, 255);
    public static final Color RED = new Color(255, 0, 0, 255);
    public static final Color BLUE = new Color(0, 0, 255, 255);
    public static final Color PINK = new Color(255, 0, 255, 255);
    public static final Color YELLOW = new Color(255, 255, 0, 255);

    public final byte r, g, b, a;

    public Color(byte r, byte g, byte b, byte a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(int r, int g, int b, int a) {
        this(
                (byte) r,
                (byte) g,
                (byte) b,
                (byte) a
        );
    }

    public int r() {
        return r & 0xFF;
    }

    public int g() {
        return g & 0xFF;
    }

    public int b() {
        return b & 0xFF;
    }

    public int a() {
        return a & 0xFF;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Color color)) return false;

        return r == color.r && g == color.g && b == color.b && a == color.a;
    }

    @Override
    public int hashCode() {
        int result = r;
        result = 31 * result + g;
        result = 31 * result + b;
        result = 31 * result + a;
        return result;
    }

    @Override
    public String toString() {
        return "Color{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
