package nowipi.jgui.component.button;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.util.Bounds;

public abstract class Button extends ButtonComponent {

    private final Bounds bounds;
    private String text;
    private Font font;
    private final Color backgroundColor;
    private final Color pressedBackgroundColor;
    private final Color hoveredBackgroundColor;
    private final Color textColor;
    private final Color pressedTextColor;
    private final Color hoveredTextColor;

    public Button(String text, Font font) {
        this(text, font,
                Color.YELLOW,
                Color.RED,
                Color.BLUE,
                Color.BLACK,
                Color.WHITE,
                Color.GREEN);
    }

    public Button(String text, Font font, Color backgroundColor, Color pressedBackgroundColor, Color hoveredBackgroundColor, Color textColor, Color pressedTextColor, Color hoveredTextColor) {
        this.bounds = new Bounds(0, font.stringWidth(text), 0, font.size(), 0);
        this.text = text;
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.pressedBackgroundColor = pressedBackgroundColor;
        this.hoveredBackgroundColor = hoveredBackgroundColor;
        this.textColor = textColor;
        this.pressedTextColor = pressedTextColor;
        this.hoveredTextColor = hoveredTextColor;
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        renderer.drawFilledBounds(bounds, getCurrentBackgroundColor());
    }

    private Color getCurrentBackgroundColor() {
        if (pressed()) {
            return pressedBackgroundColor;
        }

        if (hovered()) {
            return hoveredBackgroundColor;
        }

        return backgroundColor;
    }

    private Color getCurrentTextColor() {

        if (pressed()) {
            return pressedTextColor;
        }

        if (hovered()) {
            return hoveredTextColor;
        }

        return textColor;
    }

    public Bounds bounds() {
        return bounds;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;

        bounds.setWidthFromStart(font.stringWidth(text));
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;

        bounds.setWidthFromStart(font.stringWidth(text));
        bounds.setHeightFromStart(font.size());
    }
}
