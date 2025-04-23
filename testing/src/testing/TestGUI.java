package testing;

import nowipi.jgui.components.Container;
import nowipi.jgui.components.styling.*;
import nowipi.jgui.window.Window;

final class TestGUI {

    private final Window window;
    private final GUI gui;

    public TestGUI() {
        window = Window.create("Test GUI", 500, 500);
        gui = new GUI(new Container(
                new Styling.Builder()
                        .backgroundColor(Color.BLUE)
                        .padding(Padding.newUniform(32))
                        .build(),
                new Layout.Builder()
                        .gap(32)
                        .build(),
                new Container(
                        new Styling.Builder()
                                .fixedSize(300, 300)
                                .backgroundColor(Color.PINK)
                                .build()
                ),
                new Container(
                        new Styling.Builder()
                                .fixedSize(300, 300)
                                .backgroundColor(Color.YELLOW)
                                .build()
                )
        ));
    }

    public void show() {
        window.show();
        draw();
    }

    private void draw() {
        gui.draw();
    }

    public static void main(String[] args) {
        new TestGUI().show();
    }
}
