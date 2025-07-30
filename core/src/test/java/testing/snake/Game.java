package testing.snake;

import nowipi.jgui.Color;
import nowipi.primitives.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class Game {

    private Snake snake;
    private final List<Vector2f> food;
    private final int width, height;
    private final Random randomGenerator;
    private OpenGLGameView gameView;
    private Vector2f direction;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        food = new ArrayList<>();
        randomGenerator = new Random();
    }

    public void start() {
        randomGenerator.setSeed(System.currentTimeMillis());
        setDirection(new Vector2f(1, 0));
        snake = new Snake(Vector2f.newZeroVector());

        spawnFood();

        gameView = new OpenGLGameView(this);

        updateLoop();
    }

    private void updateLoop() {
        final int TICKS_PER_SECOND = 20;
        final long TIME_PER_TICK = 3000 / TICKS_PER_SECOND; // 50 ms
        long lastUpdateTime = System.currentTimeMillis();
        long accumulator = 0;

        boolean ate = false;

        while (notColliding() && gameView.isWindowOpen()) {

            long now = System.currentTimeMillis();
            long elapsed = now - lastUpdateTime;
            lastUpdateTime = now;
            accumulator += elapsed;

            while (accumulator >= TIME_PER_TICK) {
                snake.move(direction, ate);
                ate = isCollidingWithFood();
                accumulator -= TIME_PER_TICK;
            }

            gameView.draw(this);
        }
    }

    private Color randomColor() {
        return new Color(randomGenerator.nextInt(256), randomGenerator.nextInt(256), randomGenerator.nextInt(256), 255);
    }

    private boolean isCollidingWithFood() {
        for (int i = 0; i < food.size(); i++) {
            Vector2f foodPosition = this.food.get(i);
            if (snake.head().equals(foodPosition)) {
                gameView.snakeView().setColor(randomColor());
                this.food.remove(i);
                spawnFood();
                return true;
            }
        }
        return false;
    }

    private boolean notColliding() {
        for (int i = 0; i < snake.length(); i++) {
            Vector2f bodyPart = snake.body().get(i);
            Vector2f head = snake.head();
            if (bodyPart != head && bodyPart.equals(head)) {
                return false;
            }
        }
        return true;
    }

    public List<Vector2f> food() {
        return food;
    }

    public void spawnFood() {
        int x = randomGenerator.nextInt(width);
        int y = randomGenerator.nextInt(height);
        food.add(new Vector2f(x, y));
    }

    public Snake snake() {
        return snake;
    }

    public void setDirection(Vector2f direction) {
        this.direction = direction;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public Vector2f direction() {
        return direction;
    }
}
