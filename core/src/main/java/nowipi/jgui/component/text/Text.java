package nowipi.jgui.component.text;


import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.primitives.Rectangle;

public class Text extends TextComponent {

    private final Rectangle bounds;
    private Font font;
    private Color color;

    public Text(String string, Font font, Color color) {
        super(string);
        bounds = Rectangle.fromBottomLeft(0, 0, font.stringWidth(string), font.size());
        this.font = font;
        this.color = color;
    }

    public void growFromBottomLeft(float width, float height) {
        bounds.topRight.x = bounds.topLeft.x + width;
        bounds.bottomRight.x = bounds.bottomLeft.x + width;

        bounds.topLeft.y = bounds.bottomLeft.y + height;
        bounds.topRight.y = bounds.bottomRight.y + height;
    }

    @Override
    public void draw(ComponentRenderer renderer) {

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
        growFromBottomLeft(font.stringWidth(string()), font.size());
    }

    public Color color() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
