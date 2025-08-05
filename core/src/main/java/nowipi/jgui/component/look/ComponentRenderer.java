package nowipi.jgui.component.look;

import nowipi.jgui.Color;
import nowipi.jgui.rendering.BatchedQuadRenderer;
import nowipi.jgui.rendering.TextureRenderer;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;
import nowipi.primitives.Quad;

public final class ComponentRenderer {

    private final TextureRenderer textureRenderer;
    private final BatchedQuadRenderer quadRenderer;

    public ComponentRenderer(Matrix4f projectionMatrix, OpenGLGraphicsContext gc) {
        this.textureRenderer = new TextureRenderer(projectionMatrix, gc);
        this.quadRenderer = new BatchedQuadRenderer(projectionMatrix, gc);
    }

    public void startFrame() {
        textureRenderer.beginFrame();
        quadRenderer.beginFrame();
    }

    public void drawQuad(Quad quad, Color color) {
        quadRenderer.drawQuad(quad, color.r(), color.g(), color.b(), color.a());
    }

    public void endFrame() {
        textureRenderer.endFrame();
        quadRenderer.endFrame();
    }

    public void setProjectionMatrix(Matrix4f projectionMatrix) {
        textureRenderer.setProjection(projectionMatrix);
        quadRenderer.setProjection(projectionMatrix);
    }

}
