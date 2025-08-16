package nowipi.jgui.component;

import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.util.Bounds;
import nowipi.primitives.Rectangle;

public interface Component {

    void draw(ComponentRenderer renderer);

    Bounds bounds();
}