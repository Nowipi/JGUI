package nowipi.jgui.component.textinput;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.primitives.Rectangle;

public class TextInput extends TextInputComponent {

    private final Rectangle bounds;
    private Font font;
    private Color backgroundColor;
    private Color textColor;

    public TextInput(Font font, Color backgroundColor, Color textColor) {
        bounds = Rectangle.fromBottomLeft(0, 0, 10, font.size());
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    public void growFromBottomLeft(float width, float height) {
        bounds.topRight.x = bounds.topLeft.x + width;
        bounds.bottomRight.x = bounds.bottomLeft.x + width;

        bounds.topLeft.y = bounds.bottomLeft.y + height;
        bounds.topRight.y = bounds.bottomRight.y + height;
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        renderer.drawQuad(bounds, backgroundColor);
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

        growFromBottomLeft(font.stringWidth(input()), font.size());
    }

    public Color backgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color textColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
