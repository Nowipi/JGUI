package nowipi.jgui.components;

import nowipi.jgui.components.styling.Color;
import nowipi.primitives.Rectangle;

public final class QuadRenderCommand extends RenderCommand {

    private final Color color;

    public QuadRenderCommand(Color color, Rectangle bounds) {
        super(bounds);
        this.color = color;
    }

    public Color color() {
        return color;
    }
}
