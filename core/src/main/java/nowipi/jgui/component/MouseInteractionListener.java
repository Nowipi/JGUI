package nowipi.jgui.component;

import nowipi.jgui.component.interaction.MouseInteraction;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.input.mouse.Button;
import nowipi.jgui.window.event.WindowMouseListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static nowipi.jgui.component.RectUtils.isInside;

public class MouseInteractionListener implements WindowMouseListener {

    private record RegisteredElement(Component component, Look<Component> look, MouseInteraction interaction) {}

    private final List<RegisteredElement> registeredElements = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public <C extends Component> void registerElement(C component, Look<C> look, MouseInteraction interaction) {
        registeredElements.add(new RegisteredElement(component, (Look<Component>) look, interaction));
    }

    @Override
    public void press(Button button, int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : registeredElements) {
            Component component = element.component;
            Look<Component> look = element.look;
            MouseInteraction interaction = element.interaction;
            if (isInside(windowClientAreaX, windowClientAreaY, look.bounds(component))) {
                interaction.mousePress(windowClientAreaX, windowClientAreaY);
            }
        }
    }

    @Override
    public void release(Button button, int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : registeredElements) {
            Component component = element.component;
            Look<Component> look = element.look;
            MouseInteraction interaction = element.interaction;
            if (isInside(windowClientAreaX, windowClientAreaY, look.bounds(component))) {
                interaction.mouseRelease(windowClientAreaX, windowClientAreaY);
            }
        }
    }


    private final Set<Component> enteredComponents = new HashSet<>();

    @Override
    public void move(int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : registeredElements) {
            Component component = element.component;
            Look<Component> look = element.look;
            MouseInteraction interaction = element.interaction;
            if (isInside(windowClientAreaX, windowClientAreaY, look.bounds(component))) {
                if (!enteredComponents.contains(component)) {
                    enteredComponents.add(component);
                    interaction.mouseEnter(windowClientAreaX, windowClientAreaY);
                }
            } else {
                if (enteredComponents.contains(component)) {
                    enteredComponents.remove(component);
                    interaction.mouseExit(windowClientAreaX, windowClientAreaY);
                }
            }
        }
    }
}
