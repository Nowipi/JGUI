package nowipi.jgui.component.text;


import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.util.Bounds;

public class Text extends TextComponent {

    private final Bounds bounds;
    private Font font;
    private Color color;

    public Text(String string, Font font, Color color) {
        super(string);
        bounds = new Bounds(0, font.stringWidth(string), 0, font.size(), 0);
        this.font = font;
        this.color = color;
    }

    @Override
    public void draw(ComponentRenderer renderer) {

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
        bounds.setWidthFromStart(font.stringWidth(string()));
        bounds.setHeightFromStart(font.size());
    }

    public Color color() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
