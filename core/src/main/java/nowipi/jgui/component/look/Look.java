package nowipi.jgui.component.look;

import nowipi.primitives.Rectangle;

import java.util.List;

public interface Look {

    List<DrawCommand> draw();

    Rectangle bounds();
}
