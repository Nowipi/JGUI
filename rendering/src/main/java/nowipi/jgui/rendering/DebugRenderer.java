package nowipi.jgui.rendering;

abstract class DebugRenderer implements Renderer {

    private int drawCalls;

    private void resetDebugState() {
        drawCalls = 0;
    }

    @Override
    public void beginFrame() {
        resetDebugState();
    }

    @Override
    public void drawFrame() {
        drawCalls++;
    }

    @Override
    public void endFrame() {
        System.out.printf("%d draw calls per frame\n", drawCalls);
    }
}
