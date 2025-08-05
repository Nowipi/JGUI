package nowipi.jgui.component.look;

import nowipi.jgui.component.Component;
import nowipi.primitives.Rectangle;

import java.util.List;

public interface Look<C extends Component> {

    void draw(C c, ComponentRenderer renderer);

    Rectangle bounds(C c);
}
