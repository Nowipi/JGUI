package nowipi.jgui.input.keyboard;

import nowipi.jgui.event.EventDispatcher;

public interface Keyboard extends EventDispatcher<KeyboardEventListener> {

    void press(Key key);
    void release(Key key);

    boolean isPressed(Key key);

}
