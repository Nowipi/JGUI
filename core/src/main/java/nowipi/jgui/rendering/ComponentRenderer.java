package nowipi.jgui.rendering;

import nowipi.jgui.Color;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.look.QuadDrawCommand;
import nowipi.jgui.component.look.TextDrawCommand;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;

public class ComponentRenderer implements Renderer{

    private final BatchedQuadRenderer quadRenderer;

    public ComponentRenderer(Matrix4f projectionMatrix, OpenGLGraphicsContext gc) {
        this.quadRenderer = new BatchedQuadRenderer(projectionMatrix, gc);
    }

    public void drawComponent(Look look) {
        for (DrawCommand command : look.draw()) {
            switch (command) {
                case QuadDrawCommand quadDrawCommand -> {
                    Color color = quadDrawCommand.color();
                    quadRenderer.drawQuad(quadDrawCommand.quad(), color.r(), color.g(), color.b(), color.a());
                }
                case TextDrawCommand textDrawCommand -> {

                }
                default -> throw new IllegalArgumentException(getClass().getSimpleName() + " doesn't support " + command + " command");
            }
        }
    }

    @Override
    public void beginFrame() {
        quadRenderer.beginFrame();
    }

    @Override
    public void endFrame() {
        quadRenderer.endFrame();
    }
}
