package testing.snake;

import nowipi.jgui.Color;
import nowipi.jgui.rendering.BatchedQuadRenderer;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

final class OpenGLSnakeView {

    private static final Color SNAKE_COLOR = Color.GREEN;

    private final BatchedQuadRenderer quadRenderer;

    public OpenGLSnakeView(BatchedQuadRenderer quadRenderer, OpenGLGraphicsContext gc) {
        this.quadRenderer = quadRenderer;
    }

    public void draw(Snake snake) {
        for (int i = 0; i < snake.length(); i++) {
            quadRenderer.drawQuad(Rectangle.fromCenter(snake.body().get(i), Vector2f.newUniformVector(1)), SNAKE_COLOR.r(), SNAKE_COLOR.g(), SNAKE_COLOR.b(), SNAKE_COLOR.a());
        }
    }
}
