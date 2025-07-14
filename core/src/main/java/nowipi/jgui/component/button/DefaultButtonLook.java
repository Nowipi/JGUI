package nowipi.jgui.component.button;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.look.QuadDrawCommand;
import nowipi.jgui.component.look.TextDrawCommand;
import nowipi.primitives.Rectangle;

import java.util.List;

public class DefaultButtonLook implements Look {

    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR = Color.BLACK;

    private static final Color HOVERED_BACKGROUND_COLOR = Color.BLUE;
    private static final Color HOVERED_TEXT_COLOR = Color.WHITE;

    private static final Color PRESSED_BACKGROUND_COLOR = Color.RED;
    private static final Color PRESSED_TEXT_COLOR = Color.WHITE;


    private String text;
    private Font font;
    private Rectangle bounds;

    private final Button button;

    @SuppressWarnings("this-escape")
    public DefaultButtonLook(String text, Font font, Button button) {
        this.text = text;
        this.font = font;
        updateBounds();

        this.button = button;
    }

    public void updateBounds() {
        final float fontSize = font.size();
        bounds =  Rectangle.fromTopLeft(0, fontSize, font.stringWidth(text), fontSize);
    }

    @Override
    public List<DrawCommand> draw() {
        return List.of(new QuadDrawCommand(bounds, getCurrentBackgroundColor()),
                new TextDrawCommand(text, font, getCurrentTextColor(), bounds.topLeft));
    }

    private Color getCurrentBackgroundColor() {
        return switch (button.state()) {
            case NORMAL -> BACKGROUND_COLOR;
            case HOVERED -> HOVERED_BACKGROUND_COLOR;
            case PRESSED -> PRESSED_BACKGROUND_COLOR;
        };
    }

    private Color getCurrentTextColor() {
        return switch (button.state()) {
            case NORMAL -> TEXT_COLOR;
            case HOVERED -> HOVERED_TEXT_COLOR;
            case PRESSED -> PRESSED_TEXT_COLOR;
        };
    }

    @Override
    public Rectangle bounds() {
        return bounds;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        updateBounds();
    }

    public Font font() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        updateBounds();
    }
}
