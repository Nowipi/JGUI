package testing.snake;

import nowipi.primitives.Vector2f;

import java.util.ArrayList;
import java.util.List;

final class Snake {

    private final List<Vector2f> body;

    public Snake(Vector2f startingPosition) {
        body = new ArrayList<>();
        body.add(startingPosition);
    }

    public int length() {
        return body.size();
    }

    public Vector2f head() {
        return body.getFirst();
    }

    public void move(Vector2f direction, boolean eaten) {
        Vector2f last = body.getFirst();
        body.set(0, Vector2f.add(last, direction));
        for (int i = 1; i < body.size(); i++) {
            Vector2f current = body.get(i);
            body.set(i, last);
            last = current;
        }
        if (eaten) {
            body.add(last);
        }
    }

    public List<Vector2f> body() {
        return body;
    }
}
