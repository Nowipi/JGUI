package nowipi.jgui.component.button;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.primitives.Rectangle;

public abstract class Button extends ButtonComponent {

    private final Rectangle bounds;
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
        this.bounds = Rectangle.fromBottomLeft(0, 0, font.stringWidth(text), font.size());
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
        renderer.drawQuad(bounds, getCurrentBackgroundColor());
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

    private void growFromLeft(float amount) {
        bounds.topRight.x = bounds.topLeft.x + amount;
        bounds.bottomRight.x = bounds.bottomLeft.x + amount;
    }

    private void growFromBottom(float amount) {
        bounds.topLeft.y = bounds.bottomLeft.y + amount;
        bounds.topRight.y = bounds.bottomRight.y + amount;
    }

    public Rectangle bounds() {
        return bounds;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;

        growFromLeft(font.stringWidth(text));
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;

        growFromBottom(font.size());
        growFromLeft(font.stringWidth(text));
    }
}
