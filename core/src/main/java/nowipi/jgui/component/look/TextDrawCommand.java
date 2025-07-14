package nowipi.jgui.component.look;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.primitives.Vector2f;

public class TextDrawCommand implements DrawCommand {

    private String text;
    private Font font;
    private Color color;
    private final Vector2f bottomLeft;

    public TextDrawCommand(String text, Font font, Color color, Vector2f bottomLeft) {
        this.text = text;
        this.font = font;
        this.color = color;
        this.bottomLeft =  bottomLeft;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Vector2f bottomLeft() {
        return bottomLeft;
    }
}
