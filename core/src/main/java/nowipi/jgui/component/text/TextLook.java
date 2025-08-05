package nowipi.jgui.component.text;


import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.look.Look;
import nowipi.primitives.Rectangle;

public class TextLook implements Look<Text> {

    private Font font;
    private Color color;

    public TextLook(Font font, Color color) {
        this.font = font;
        this.color = color;
    }

    @Override
    public void draw(Text text, ComponentRenderer renderer) {

    }

    @Override
    public Rectangle bounds(Text text) {
        final float fontSize = font.size();
        return Rectangle.fromBottomLeft(0, 0, font.stringWidth(text.string()), fontSize);
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color color() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
