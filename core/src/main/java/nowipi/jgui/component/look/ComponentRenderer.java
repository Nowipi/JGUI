package nowipi.jgui.component.look;

import nowipi.jgui.Color;
import nowipi.jgui.component.util.Bounds;
import nowipi.jgui.rendering.BatchedFilledQuadRenderer;
import nowipi.jgui.rendering.TextureRenderer;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.primitives.Matrix4f;

public final class ComponentRenderer {

    private final TextureRenderer textureRenderer;
    private final BatchedFilledQuadRenderer quadRenderer;

    public ComponentRenderer(Matrix4f projectionMatrix, OpenGLGraphicsContext gc) {
        this.textureRenderer = new TextureRenderer(projectionMatrix, gc);
        this.quadRenderer = new BatchedFilledQuadRenderer(projectionMatrix, gc);
    }

    public void startFrame() {
        textureRenderer.beginFrame();
        quadRenderer.beginFrame();
    }

    public void drawFilledBounds(Bounds bounds, Color color) {
        quadRenderer.drawVertices(bounds.vertices(), color.r(), color.g(), color.b(), color.a());
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
