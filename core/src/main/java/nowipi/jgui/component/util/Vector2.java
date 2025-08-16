package nowipi.jgui.component.util;

public class Vector2 {

    private Vector2() {}

    public static float squaredLength(float x, float y) {
        return x * x + y * y;
    }

    public static float length(float x, float y) {
        return (float)Math.sqrt(squaredLength(x, y));
    }

    public static float dot(float aX, float aY, float bX, float bY) {
        return aX * bX + aY * bY;
    }

}
