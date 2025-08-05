package nowipi.jgui.component.checkbox;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.look.Look;
import nowipi.primitives.Rectangle;

public class CheckboxLook implements Look<Checkbox> {

    private Font font;
    private Rectangle bounds;

    public CheckboxLook(Font font) {
        this.font = font;
        bounds = calculateBounds(font.size());
    }

    public static Rectangle calculateBounds(float fontSize) {
        return Rectangle.fromTopLeft(0, fontSize, fontSize, fontSize);
    }

    @Override
    public void draw(Checkbox checkbox, ComponentRenderer renderer) {
        if (checkbox.isChecked()) {
            renderer.drawQuad(bounds, Color.BLUE);
        } else {
            renderer.drawQuad(bounds, Color.BLACK);
        }
    }

    @Override
    public Rectangle bounds(Checkbox checkbox) {
        return bounds;
    }

    public void setFont(Font font) {
        this.font = font;
        bounds = calculateBounds(font.size());
    }

    public Font font() {
        return font;
    }
}
