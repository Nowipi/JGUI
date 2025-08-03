package testing.snake;

import nowipi.jgui.Color;
import nowipi.jgui.rendering.BatchedQuadRenderer;
import nowipi.jgui.rendering.OpenGLTexture;
import nowipi.jgui.rendering.TextureRenderer;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.*;
import testing.ResourceManager;

import java.io.IOException;

final class OpenGLSnakeView {

    private Color color = Color.GREEN;
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

    public void draw(Snake snake, Vector2f direction) {

        Vector2f textureOrigin = snake.head();
        Rectangle textureBounds = Rectangle.fromCenter(textureOrigin, Vector2f.newUniformVector(1));
        rotate(textureBounds, textureOrigin, Math.atan2(direction.y, direction.x) + (Math.PI * 0.5));
        textureRenderer.drawTexture(headTexture, textureBounds, color.r(), color.g(), color.b(), color.a());
        for (int i = 1; i < snake.length(); i++) {
            Rectangle bodyBounds = Rectangle.fromCenter(snake.body().get(i), Vector2f.newUniformVector(1));
            quadRenderer.drawQuad(bodyBounds, color.r(), color.g(), color.b(), color.a());
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static void rotate(Quad quad, Vector2f around, double radians) {
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);

        for (Vector2f v : quad.vertices()) {
            Vector2f d = Vector2f.sub(v, around);

            float rotatedX = d.x * cos - d.y * sin;
            float rotatedY = d.x * sin + d.y * cos;

            v.x = rotatedX + around.x;
            v.y = rotatedY + around.y;
        }
    }
}
