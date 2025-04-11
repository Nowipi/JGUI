package testing;

import nowipi.jgui.components.Component;
import nowipi.jgui.components.Container;
import nowipi.jgui.components.styling.Styling;
import nowipi.jgui.window.Window;

final class TestGUI {

    private final Window window;
    private final Component root;

    public TestGUI() {
        window = Window.create("Test GUI", 500, 500);
        root = new Container(
                new Styling.Builder()
                        .fixedSize(100, 100)
                        .build()
        );
    }

    public void show() {
        window.show();
        draw();
    }

    private void draw() {
        switch (root) {
            case Container c -> {
                Styling style = c.styling();
                float width = style.size.width.size(c);
                float height = style.size.height.size(c);
                System.out.println("draw at 0 0 with size " + width + " " + height);
            }
            default -> throw new IllegalStateException("Unexpected value: " + root);
        }
    }

    public static void main(String[] args) {
        new TestGUI().show();
    }
}
