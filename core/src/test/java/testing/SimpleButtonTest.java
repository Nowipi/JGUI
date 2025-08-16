package testing;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.Rectangle;
import nowipi.jgui.component.MouseInteractionListener;
import nowipi.jgui.component.button.Button;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowBegin;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.rendering.OpenGL;
import nowipi.jgui.window.Window;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;

final class SimpleButtonTest {
    public static void main(String[] args) {
        Window window = Window.createWindowed("Simple Button Test", 1080, 720);
        OpenGLGraphicsContext gc = OpenGL.createGraphicsContext(window, 4, 2, OpenGL.Profile.CORE);
        Rectangle windowBounds = window.bounds();
        ComponentRenderer renderer = new ComponentRenderer(calculateProjectionMatrix(windowBounds.width(), windowBounds.height()), gc);


        window.addListener((width, height) -> {
            gc.glViewport(0, 0, width, height);
            renderer.setProjectionMatrix(calculateProjectionMatrix(width, height));

        });
        MouseInteractionListener mouseInteractionListener = new MouseInteractionListener();
        window.addListener(mouseInteractionListener);


        Font font = new Font.FontBuilder().size(16).build();
        Button buttonA = new Button("click me!", font) {
            @Override
            public void click() {
                System.out.println("You clicked button A!");
            }
        };

        Button buttonB = new Button("click me!", font) {
            @Override
            public void click() {
                System.out.println("You clicked button B!");
            }
        };


        Container c = new Container(Color.TRANSPARENT, FlowDirection.VERTICAL, buttonA, buttonB);
        c.bounds().moveXStart(100);
        c.updateBounds();

        mouseInteractionListener.registerElement(buttonA, buttonA);
        mouseInteractionListener.registerElement(buttonB, buttonB);

        window.show();

        while (!window.shouldClose()) {
            window.pollEvents();
            renderer.startFrame();
            c.draw(renderer);
            renderer.endFrame();
            window.swapBuffers();
        }
    }

    private static Matrix4f calculateProjectionMatrix(int width, int height) {
        return Matrix4f.ortho(0, width, 0, height, -1, 1);
    }
}
