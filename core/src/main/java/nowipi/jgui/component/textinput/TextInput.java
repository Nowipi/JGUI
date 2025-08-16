package nowipi.jgui.component.textinput;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.util.Bounds;

public class TextInput extends TextInputComponent {

    private final Bounds bounds;
    private Font font;
    private Color backgroundColor;
    private Color textColor;

    public TextInput(Font font, Color backgroundColor, Color textColor) {
        bounds = new Bounds(0, 10, 0, font.size(), 0);
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        renderer.drawFilledBounds(bounds, backgroundColor);
    }

    @Override
    public Bounds bounds() {
        return bounds;
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;

        bounds.setWidthFromStart(font().stringWidth(input()));
        bounds.setHeightFromStart(font.size());
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
