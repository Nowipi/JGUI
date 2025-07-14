package nowipi.jgui.component.look;

import nowipi.jgui.Color;
import nowipi.primitives.Quad;

public class QuadDrawCommand implements DrawCommand {

    private Color color;
    private final Quad quad;

    public QuadDrawCommand(Quad quad, Color color) {
        this.quad = quad;
        this.color = color;
    }

    public Color color() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Quad quad() {
        return quad;
    }
}
