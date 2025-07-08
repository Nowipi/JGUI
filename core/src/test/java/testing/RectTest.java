package testing;

import nowipi.jgui.rendering.BatchedQuadRenderer;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.jgui.window.event.WindowResizeEvent;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

import static nowipi.opengl.OpenGL.*;

final class RectTest {

    private final Window window;
    private BatchedQuadRenderer renderer;
    private OpenGLGraphicsContext gc;

    public RectTest() {
        window = Window.createWindowed("Rect test window", 1080, 720);
    }

    public void run() {

        gc = OpenGL.createGraphicsContext(window);

        gc.glEnable(GL_BLEND);
        gc.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        renderer = new BatchedQuadRenderer(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1), gc);

        window.addListener(WindowResizeEvent.class, event -> onResizeWindow(event.width(), event.height()));

        window.show();

        while (!window.shouldClose()) {
            renderFrame();
            window.pollEvents();
        }
    }

    private void onResizeWindow(int windowWidth, int windowHeight) {
        gc.glViewport(0, 0, windowWidth, windowHeight);
        renderer.setProjection(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1));
        renderFrame();
    }

    long lastTime = System.nanoTime();
    private void renderFrame() {
        long current = System.nanoTime();
        float delta = (current - lastTime) / 1_000_000_000f;
        lastTime = current;

        gc.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gc.glClearColor(1, 1, 1, 1);
        renderer.beginFrame();
        renderer.drawQuad(new Rectangle(new Vector2f(100, 100), new Vector2f(135, 135), -50), 255, 0, 255, 100);
        renderer.drawQuad(Rectangle.fromCenter(window.width()/2f, window.height()/2f, 100, 100), 255, 255, 0, 100);

        renderer.drawQuad(Rectangle.fromTopLeft(window.width() - 100, 0, 100, -100), 0, 0, 255, 100);
        renderer.endFrame();
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new RectTest().run();
    }

}
