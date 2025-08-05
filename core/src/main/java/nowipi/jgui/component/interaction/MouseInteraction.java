package nowipi.jgui.component.interaction;

public interface MouseInteraction {

    void mouseEnter(int screenX, int screenY);
    void mouseExit(int screenX, int screenY);
    void mousePress(int screenX, int screenY);
    void mouseRelease(int screenX, int screenY);

}
