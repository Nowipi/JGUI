package nowipi.jgui.component.checkbox;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.look.TextDrawCommand;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

import java.util.List;

public class DefaultCheckboxLook implements Look {

    private static final Color TEMP_COLOR = Color.BLACK;

    private final Checkbox checkbox;
    private Font font;
    private Rectangle bounds;

    @SuppressWarnings("this-escape")
    public DefaultCheckboxLook(Checkbox checkbox, Font font) {
        this.checkbox = checkbox;
        this.font = font;
        updateBounds();
    }

    public void updateBounds() {
        final float fontSize = font.size();
        bounds =  Rectangle.fromTopLeft(0, fontSize, fontSize, fontSize);
    }

    @Override
    public List<DrawCommand> draw() {
        return List.of(
                checkbox.isChecked() ? new TextDrawCommand("X", font, TEMP_COLOR, new Vector2f(0, 0)) : new TextDrawCommand("-", font, TEMP_COLOR, new Vector2f(0, 0))
        );
    }

    @Override
    public Rectangle bounds() {
        return bounds;
    }

    public void setFont(Font font) {
        this.font = font;
        updateBounds();
    }

    public Font font() {
        return font;
    }
}
