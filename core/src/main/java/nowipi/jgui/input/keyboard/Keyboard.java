package nowipi.jgui.input.keyboard;

import nowipi.jgui.event.ArrayListEventDispatcher;

import java.util.HashSet;
import java.util.Set;

public class Keyboard extends ArrayListEventDispatcher<KeyboardEventListener> {

    private static final int INITIAL_CAPACITY_BASED_ON_ROLL_OVER = 6;

    private final Set<Key> pressedKeys;

    public Keyboard() {
        pressedKeys = new HashSet<>(INITIAL_CAPACITY_BASED_ON_ROLL_OVER);
    }

    public void press(Key key) {
        if (pressedKeys.add(key)) {
            dispatch(l -> l.press(key));
        }
    }

    public boolean isPressed(Key key) {
        return pressedKeys.contains(key);
    }

    public void release(Key key) {
        if (pressedKeys.remove(key)) {
            dispatch(l -> l.release(key));
        }
    }
}
