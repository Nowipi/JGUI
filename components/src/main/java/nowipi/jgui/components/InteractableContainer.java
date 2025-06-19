package nowipi.jgui.components;

import nowipi.jgui.components.styling.ContainerLayout;
import nowipi.jgui.components.styling.Layout;
import nowipi.jgui.components.styling.Styling;

import java.util.List;

public class InteractableContainer extends Container implements Interactable {

    private final Runnable interact;

    public InteractableContainer(List<Component> children, Runnable interact) {
        super(children);
        this.interact = interact;
    }

    public InteractableContainer(Styling styling, ContainerLayout layout, List<Component> children, Runnable interact) {
        super(styling, layout, children);
        this.interact = interact;
    }

    public InteractableContainer(ContainerLayout layout, List<Component> children, Runnable interact) {
        super(layout, children);
        this.interact = interact;
    }

    @Override
    public void interact() {
        interact.run();
    }
}
