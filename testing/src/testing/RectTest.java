package testing;

import nowipi.jgui.rendering.BatchedRectangleRenderer;
import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.jgui.window.event.WindowResizeEvent;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;

import static nowipi.opengl.OpenGL.*;

final class RectTest {

    private final Window window;
    private BatchedRectangleRenderer renderer;

    public RectTest() {
        window = Window.createWindowed("Rect test window", 2560, 1440);
    }

    public void run() {

        GraphicsContext graphicsContext = window.createGraphicsContext();
        graphicsContext.makeCurrent();
        OpenGL.init(graphicsContext);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        renderer = new BatchedRectangleRenderer(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1));

        window.addListener(WindowResizeEvent.class, event -> onResizeWindow(event.width(), event.height()));

        window.show();

        while (!window.shouldClose()) {
            renderFrame();
            window.pollEvents();
        }
    }

    private void onResizeWindow(int windowWidth, int windowHeight) {
        glViewport(0, 0, windowWidth, windowHeight);
        renderer.setProjection(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1));
        renderFrame();
    }

    long lastTime = System.nanoTime();
    private void renderFrame() {
        long current = System.nanoTime();
        float delta = (current - lastTime) / 1_000_000_000f;
        lastTime = current;

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(1, 1, 1, 1);
        renderer.beginFrame();
        renderer.drawRectangle(Rectangle.fromTopLeft(0, 0, 100, -100), 255, 0, 255, 100);
        renderer.drawRectangle(Rectangle.fromCenter(window.width()/2f, window.height()/2f, 100, 100), 255, 255, 0, 100);

        renderer.drawRectangle(Rectangle.fromTopLeft(window.width() - 100, 0, 100, -100), 0, 0, 255, 100);
        renderer.endFrame();
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new RectTest().run();
    }

}
