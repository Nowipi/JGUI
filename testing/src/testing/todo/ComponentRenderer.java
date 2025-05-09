package testing.todo;

import nowipi.jgui.components.Checkbox;
import nowipi.jgui.components.Component;
import nowipi.jgui.components.Container;
import nowipi.jgui.components.styling.Color;
import nowipi.jgui.rendering.BatchedRectangleRenderer;
import nowipi.jgui.rendering.Renderer;
import nowipi.jgui.rendering.TextureRenderer;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Rectangle;

final class ComponentRenderer implements Renderer {

    private final BatchedRectangleRenderer rectangleRenderer;
    //private final TextRenderer textRenderer;
    private final TextureRenderer textureRenderer;

    public ComponentRenderer(Matrix4f projection) {
        rectangleRenderer = new BatchedRectangleRenderer(projection);
        //textRenderer = new TextRenderer();
        textureRenderer = new TextureRenderer(projection);
    }

    @Override
    public void beginFrame() {

    }

    public void renderComponent(Component component) {
        var componentRect = Rectangle.fromTopLeft(component.x, component.y, component.width, component.height);
        switch (component) {
            case Container container -> {
                rectangleRenderer.drawRectangle(componentRect, component.styling.backgroundColor);
                for (Component child : container.children()) {
                    renderComponent(child);
                }
            }
            /*case Text text -> {
                textRenderer.drawText(componentRect, text.text());
            }*/
            case Checkbox checkbox -> {
                if (checkbox.checked()) {
                    rectangleRenderer.drawRectangle(componentRect, Color.BLUE);
                } else {
                    rectangleRenderer.drawRectangle(componentRect, Color.WHITE);
                }
            }
            default -> {}
        }
    }

    @Override
    public void endFrame() {

    }
}
