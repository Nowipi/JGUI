package nowipi.jgui.component.text;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.look.TextDrawCommand;
import nowipi.primitives.Rectangle;

import java.util.List;

public class DefaultTextLook implements Look {

    private final Text text;
    private Font font;
    private Color color;
    private Rectangle bounds;


    @SuppressWarnings("this-escape")
    public DefaultTextLook(Text text, Font font, Color color) {
        this.text = text;
        this.font = font;
        this.color = color;
        updateBounds();
    }

    @Override
    public List<DrawCommand> draw() {
        return List.of(
                new TextDrawCommand(text.text(), font, color, bounds.bottomLeft)
        );
    }

    public void updateBounds() {
        final float fontSize = font.size();
        bounds = Rectangle.fromBottomLeft(0, 0, font.stringWidth(text.text()), fontSize);
    }

    @Override
    public Rectangle bounds() {
        return bounds;
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        updateBounds();
    }

    public Color color() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
