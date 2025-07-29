package testing.snake;

import nowipi.jgui.Color;
import nowipi.jgui.input.keyboard.Key;
import nowipi.jgui.input.keyboard.KeyboardEventListener;
import nowipi.jgui.rendering.BatchedQuadRenderer;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.rendering.TextureRenderer;
import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

import java.util.List;
import java.util.Optional;

import static nowipi.opengl.OpenGL.GL_COLOR_BUFFER_BIT;
import static nowipi.opengl.OpenGL.GL_DEPTH_BUFFER_BIT;

final class OpenGLGameView {

    private static final Color FOOD_COLOR = Color.RED;

    private final OpenGLSnakeView snakeView;
    private final Window window;
    private final OpenGLGraphicsContext gc;
    private final BatchedQuadRenderer quadRenderer;

    public OpenGLGameView(Game game) {
        window = Window.createWindowed("Snake", 1080, 720);
        window.addListener(new KeyboardEventListener() {
            @Override
            public void press(Key key) {
                Optional<Vector2f> direction = switch (key) {
                    case LEFT  -> Optional.of(new Vector2f(-1, 0));
                    case RIGHT -> Optional.of(new Vector2f(1, 0));
                    case UP    -> Optional.of(new Vector2f(0, -1));
                    case DOWN  -> Optional.of(new Vector2f(0, 1));
                    default -> Optional.empty();
                };
                direction.ifPresent(game::setDirection);
            }

            @Override
            public void release(Key key) {

            }
        });
        gc = OpenGL.createGraphicsContext(window);

        Rectangle windowBounds = window.bounds();
        float aspectRatio = windowBounds.width() / windowBounds.height();
        Matrix4f projectionMatrix = Matrix4f.ortho(0, game.height() * aspectRatio, 0, game.height(), -1, 1);
        quadRenderer = new BatchedQuadRenderer(projectionMatrix, gc);
        snakeView = new OpenGLSnakeView(quadRenderer, gc);


        window.show();
    }

    public void draw(Game game) {
        window.pollEvents();

        gc.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gc.glClearColor(1f, 1f, 1f, 1f);

        quadRenderer.beginFrame();

        snakeView.draw(game.snake());

        drawFood(game.food());

        quadRenderer.endFrame();

        window.swapBuffers();
    }

    private void drawFood(List<Vector2f> food) {
        for (Vector2f foodPosition : food) {
            quadRenderer.drawQuad(Rectangle.fromCenter(foodPosition, Vector2f.newUniformVector(1)), FOOD_COLOR.r(), FOOD_COLOR.g(), FOOD_COLOR.b(), FOOD_COLOR.a());
        }
    }

    public boolean isWindowOpen() {
        return !window.shouldClose();
    }
}
