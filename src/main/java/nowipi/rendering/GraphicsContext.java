package nowipi.rendering;

import nowipi.windowing.Disposable;
import nowipi.windowing.DrawingSurface;

public abstract class GraphicsContext <DrawingSurfaceType extends DrawingSurface> implements Disposable {

    protected final DrawingSurfaceType surface;

    public GraphicsContext(DrawingSurfaceType surface) {
        this.surface = surface;
    }

    public abstract void makeCurrent();
}
