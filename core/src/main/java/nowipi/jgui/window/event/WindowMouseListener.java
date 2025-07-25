package nowipi.jgui.window.event;

import nowipi.jgui.event.EventListener;
import nowipi.jgui.input.mouse.Button;

public interface WindowMouseListener extends EventListener {

    void press(Button button, int windowClientAreaX, int windowClientAreaY);
    void release(Button button, int windowClientAreaX, int windowClientAreaY);

    void move(float windowClientAreaX, float windowClientAreaY);

}
