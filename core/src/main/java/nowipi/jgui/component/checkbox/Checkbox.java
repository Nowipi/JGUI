package nowipi.jgui.component.checkbox;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.util.Bounds;

public class Checkbox extends CheckboxComponent {

    private final Bounds bounds;
    private Font font;

    public Checkbox(Font font) {
        final float fontSize = font.size();
        bounds = new Bounds(0, fontSize, 0, fontSize, 0);
        this.font = font;
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        if (isChecked()) {
            renderer.drawFilledBounds(bounds, Color.BLUE);
        } else {
            renderer.drawFilledBounds(bounds, Color.BLACK);
        }
    }

    @Override
    public Bounds bounds() {
        return bounds;
    }

    public void setFont(Font font) {
        this.font = font;
        bounds.setWidthFromStart(font.size());
        bounds.setHeightFromStart(font.size());
    }

    public Font font() {
        return font;
    }
}
