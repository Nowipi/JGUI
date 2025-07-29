package testing.snake;

import nowipi.jgui.Color;
import nowipi.jgui.rendering.BatchedQuadRenderer;
import nowipi.jgui.rendering.OpenGLTexture;
import nowipi.jgui.rendering.TextureRenderer;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;
import testing.ResourceManager;

import java.io.IOException;

final class OpenGLSnakeView {

    private static final Color SNAKE_COLOR = Color.GREEN;

    private final BatchedQuadRenderer quadRenderer;
    private final TextureRenderer textureRenderer;
    private final OpenGLTexture headTexture;

    public OpenGLSnakeView(BatchedQuadRenderer quadRenderer, TextureRenderer textureRenderer, OpenGLGraphicsContext gc) {
        this.quadRenderer = quadRenderer;
        this.textureRenderer = textureRenderer;
        try {
            headTexture = ResourceManager.loadTexture("snake/snake_head.png", gc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Snake snake) {
        final Rectangle headTextureBounds = Rectangle.fromCenter(snake.head(), Vector2f.newUniformVector(1));
        textureRenderer.beginFrame();
        textureRenderer.drawTexture(headTexture,
                (int) headTextureBounds.topLeft.x,
                (int) headTextureBounds.topLeft.y,
                (int) headTextureBounds.width(),
                (int) headTextureBounds.height(),
                90,
                1,
                1,
                1,
                1);
        textureRenderer.endFrame();
        for (int i = 1; i < snake.length(); i++) {
            quadRenderer.drawQuad(Rectangle.fromCenter(snake.body().get(i), Vector2f.newUniformVector(1)), SNAKE_COLOR.r(), SNAKE_COLOR.g(), SNAKE_COLOR.b(), SNAKE_COLOR.a());
        }
    }
}
