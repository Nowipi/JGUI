package testing;

import nowipi.jgui.opengl.GraphicsContext;
import nowipi.jgui.opengl.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.jgui.window.event.WindowResizeEvent;

import java.io.IOException;

import static nowipi.jgui.opengl.OpenGL.*;

final class RectTest {

    private final Window window;
    private TextureRenderer renderer;
    private OpenGLTexture arrowTexture;
    private OpenGLTexture texture;

    public RectTest() {
        window = Window.create("Rect test window", 1080, 512);
    }

    public void run() {

        GraphicsContext graphicsContext = window.createGraphicsContext();
        graphicsContext.makeCurrent();
        OpenGL.init(graphicsContext);

        renderer = new TextureRenderer();

        try {
            arrowTexture = ResourceManager.loadTexture("texture.png");
            texture = ResourceManager.loadTexture("pic.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        window.addListener(WindowResizeEvent.class, event -> onResizeWindow(event.width(), event.height()));

        window.show();

        renderer.setProjection(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1));
        while (!window.shouldClose()) {
            renderFrame();
            window.pollEvents();
        }
        renderer.dispose();
    }

    private void onResizeWindow(int windowWidth, int windowHeight) {
        glViewport(0, 0, windowWidth, windowHeight);
        renderer.setProjection(Matrix4f.ortho(0, window.width(), 0, window.height(), -1, 1));
        renderFrame();
    }

    private static final float rotationSpeed = 360f; // degrees per second
    private float rotation;

    long lastTime = System.nanoTime();
    private void renderFrame() {
        long current = System.nanoTime();
        float delta = (current - lastTime) / 1_000_000_000f;
        lastTime = current;


        rotation += rotationSpeed * delta;

        renderer.beginFrame();
        glClear(GL_COLOR_BUFFER_BIT);
        glClearColor(1, 1, 1, 1);
        renderer.drawTexture(arrowTexture, 100, 100, 200, 200, rotation, 1, 1, 1, 1);
        renderer.drawTexture(texture, 0, 0, 100, 100, 0, 1, 1, 1, 1);
        window.swapBuffers();
        renderer.endFrame();
    }

    public static void main(String[] args) {
        new RectTest().run();
    }

}
