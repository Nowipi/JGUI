package nowipi.jgui.components;

import nowipi.primitives.Rectangle;

public abstract sealed class RenderCommand permits QuadRenderCommand, TextRenderCommand {

    private final Rectangle bounds;

    public RenderCommand(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle bounds() {
        return bounds;
    }
}
