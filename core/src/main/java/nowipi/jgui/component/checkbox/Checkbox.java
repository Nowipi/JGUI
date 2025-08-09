package nowipi.jgui.component.checkbox;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.primitives.Rectangle;

public class Checkbox extends CheckboxComponent {

    private final Rectangle bounds;
    private Font font;

    public Checkbox(Font font) {
        final float fontSize = font.size();
        bounds = Rectangle.fromBottomLeft(0, 0, fontSize, fontSize);
        this.font = font;
    }

    private void growFromBottomLeft(float amount) {
        bounds.topRight.x = bounds.topLeft.x + amount;
        bounds.bottomRight.x = bounds.bottomLeft.x + amount;

        bounds.topLeft.y = bounds.bottomLeft.y + amount;
        bounds.topRight.y = bounds.bottomRight.y + amount;
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        if (isChecked()) {
            renderer.drawQuad(bounds, Color.BLUE);
        } else {
            renderer.drawQuad(bounds, Color.BLACK);
        }
    }

    @Override
    public Rectangle bounds() {
        return bounds;
    }

    public void setFont(Font font) {
        this.font = font;
        growFromBottomLeft(font.size());
    }

    public Font font() {
        return font;
    }
}
