package nowipi.jgui.component;

import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

public final class RectUtils {

    private RectUtils() {
    }

    public static boolean isInside(int x, int y, Rectangle bounds) {
        Vector2f p = new Vector2f(x, y);

        Vector2f[] corners = new Vector2f[] {
                bounds.topLeft,
                bounds.topRight,
                bounds.bottomRight,
                bounds.bottomLeft
        };

        boolean allPositive = true;
        boolean allNegative = true;

        for (int i = 0; i < 4; i++) {
            Vector2f a = corners[i];
            Vector2f b = corners[(i + 1) % 4];

            Vector2f edge = Vector2f.sub(b, a);
            Vector2f toPoint = Vector2f.sub(p, a);

            float cross = cross(edge, toPoint);

            if (cross < 0) allPositive = false;
            if (cross > 0) allNegative = false;
        }

        return allPositive || allNegative;
    }

    public static float cross(Vector2f a, Vector2f b) {
        return a.x * b.y - a.y * b.x;
    }
}
