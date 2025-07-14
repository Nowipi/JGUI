package nowipi.jgui.input.keyboard;

import nowipi.jgui.event.EventListener;

public interface KeyboardEventListener extends EventListener {

    void press(Key key);
    void release(Key key);

}
