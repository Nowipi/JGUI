package nowipi.jgui.component;

import nowipi.primitives.Rectangle;

public abstract class Layout<C extends Component> {

    public final Rectangle bounds;

    public Layout() {
        bounds = new Rectangle(0,0,0,0);
    }
}
