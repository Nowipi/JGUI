package testing;

import nowipi.jgui.components.*;

final class GUI {

    private final Component root;

    public GUI(Component root) {
        this.root = root;
    }

    public void draw() {
        draw(root);
    }

    private void draw(Component component) {
        if (component instanceof Container container) {

            float leftOffset = component.styling.padding.left;
            for (Component child : container.children()) {
                System.out.println("draw at " + leftOffset);
                leftOffset += child.styling.size.width.size(child) + container.layout.gap;
            }
        } else {
            System.out.println("Drawing a non-Container component " + component);
        }
    }

    public void resize(int width, int height) {

    }
}
