package nowipi.jgui.component.textinput;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.look.Look;
import nowipi.primitives.Rectangle;

public class TextInputLook implements Look<TextInput> {

    private static final float PADDING = 10;

    private Font font;
    private Color backgroundColor;
    private Color textColor;

    public TextInputLook(Font font, Color backgroundColor, Color textColor) {
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public void draw(TextInput input, ComponentRenderer renderer) {
        Rectangle bounds = bounds(input);
        renderer.drawQuad(bounds, backgroundColor);
    }

    @Override
    public Rectangle bounds(TextInput input) {
        final float extraSpace = 2 * PADDING;
        return Rectangle.fromBottomLeft(0, 0, font.stringWidth(input.input()) + extraSpace, font.size() + extraSpace);
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
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
