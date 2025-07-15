package nowipi.jgui.input.mouse;

import nowipi.jgui.event.EventDispatcher;

public interface Mouse extends EventDispatcher<MouseEventListener> {

    boolean isPressed(Button button);

    int x();
    int y();

    /**
     * Changes the mouse position and dispatches a mouse move event.
     * @param x new mouse x position.
     * @param y new mouse y position.
     */
    void setPosition(int x, int y);

    /**
     * Presses a button and dispatches a press event.
     * @param button the mouse button to be pressed.
     */
    void press(Button button);

    /**
     * Releases a button and dispatches a release event.
     * @param button the mouse button to be released.
     */
    void release(Button button);
}
