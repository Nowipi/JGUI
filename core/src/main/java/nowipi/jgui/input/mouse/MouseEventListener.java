package nowipi.jgui.input.mouse;

import nowipi.jgui.event.EventListener;

public interface MouseEventListener extends EventListener {

    void press(Button button);
    void release(Button button);

    void move(float x, float y);

}
