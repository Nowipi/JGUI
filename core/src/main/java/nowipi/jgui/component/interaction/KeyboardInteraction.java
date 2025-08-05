package nowipi.jgui.component.interaction;

import nowipi.jgui.input.keyboard.Key;

public interface KeyboardInteraction {

    void keyPress(Key key);
    void keyRelease(Key key);

}
