package nowipi.jgui.components;

import nowipi.jgui.components.styling.Color;
import nowipi.primitives.Rectangle;

public final class TextRenderCommand extends RenderCommand {

    private final String text;
    private final Color color;

    public TextRenderCommand(String text, Color color, Rectangle bounds) {
        super(bounds);
        this.text = text;
        this.color = color;
    }

    public String text() {
        return text;
    }

    public Color color() {
        return color;
    }
}
