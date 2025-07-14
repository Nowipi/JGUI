package nowipi.jgui.component.textinput;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.look.QuadDrawCommand;
import nowipi.jgui.component.look.TextDrawCommand;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

import java.util.List;

public class DefaultTextInputLook implements Look {

    private static final float PADDING = 10;

    private final TextInput textInput;
    private Font font;
    private Color backgroundColor;
    private Color textColor;
    private Rectangle bounds;

    @SuppressWarnings("this-escape")
    public DefaultTextInputLook(TextInput textInput, Font font, Color backgroundColor, Color textColor) {
        this.textInput = textInput;
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        updateBounds();
    }

    public void updateBounds() {
        final float extraSpace = 2 * PADDING;
        bounds = Rectangle.fromBottomLeft(0, 0, font.stringWidth(textInput.text()) + extraSpace, font.size() + extraSpace);
    }

    @Override
    public List<DrawCommand> draw() {
        return List.of(
                new QuadDrawCommand(bounds, backgroundColor),
                new TextDrawCommand(textInput.text(), font, textColor, Vector2f.add(bounds.bottomLeft, Vector2f.newUniformVector(PADDING)))
        );
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
