package nowipi.jgui.component.button;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.*;
import nowipi.primitives.Rectangle;

public class ButtonLook implements Look<Button> {

    private static final Color BACKGROUND_COLOR = Color.YELLOW;
    private static final Color TEXT_COLOR = Color.BLACK;

    private static final Color HOVERED_BACKGROUND_COLOR = Color.BLUE;
    private static final Color HOVERED_TEXT_COLOR = Color.WHITE;

    private static final Color PRESSED_BACKGROUND_COLOR = Color.RED;
    private static final Color PRESSED_TEXT_COLOR = Color.WHITE;


    private String text;
    private Font font;
    private Rectangle bounds;

    public ButtonLook(String text, Font font) {
        this.text = text;
        this.font = font;
        bounds = calculateBounds(text, font);
    }

    public static Rectangle calculateBounds(String text, Font font) {
        final float fontSize = font.size();
        return Rectangle.fromTopLeft(0, fontSize, font.stringWidth(text), fontSize);
    }

    @Override
    public void draw(Button button, ComponentRenderer renderer) {
        final Rectangle bounds = bounds(button);

        renderer.drawQuad(bounds, getCurrentBackgroundColor(button));
    }

    private Color getCurrentBackgroundColor(Button button) {
        if (button.isPressed()) {
            return PRESSED_BACKGROUND_COLOR;
        }

        if (button.isHovered()) {
            return HOVERED_BACKGROUND_COLOR;
        }

        return BACKGROUND_COLOR;
    }

    private Color getCurrentTextColor(Button button) {

        if (button.isPressed()) {
            return PRESSED_TEXT_COLOR;
        }

        if (button.isHovered()) {
            return HOVERED_TEXT_COLOR;
        }

        return TEXT_COLOR;
    }

    @Override
    public Rectangle bounds(Button button) {
        return bounds;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        bounds = calculateBounds(text, font);
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        bounds = calculateBounds(text, font);
    }
}
