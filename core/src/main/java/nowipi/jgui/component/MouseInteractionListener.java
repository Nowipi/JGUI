package nowipi.jgui.component;

import nowipi.jgui.component.interaction.MouseInteraction;
import nowipi.jgui.input.mouse.Button;
import nowipi.jgui.window.event.WindowMouseListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static nowipi.jgui.component.RectUtils.isInside;

public class MouseInteractionListener implements WindowMouseListener {

    private record RegisteredElement(Component component, MouseInteraction interaction) {
    }

    private final List<RegisteredElement> registeredElements = new ArrayList<>();


    public void registerElement(Component component, MouseInteraction interaction) {
        registeredElements.add(new RegisteredElement(component, interaction));
    }

    @Override
    public void press(Button button, int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : registeredElements) {
            var bounds = element.component().bounds();

            MouseInteraction interaction = element.interaction;
            if (isInside(windowClientAreaX, windowClientAreaY, bounds)) {
                interaction.mousePress(windowClientAreaX, windowClientAreaY);
            }
        }
    }

    @Override
    public void release(Button button, int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : new ArrayList<>(registeredElements)) {
            var bounds = element.component().bounds();

            MouseInteraction interaction = element.interaction;
            if (isInside(windowClientAreaX, windowClientAreaY, bounds)) {
                interaction.mouseRelease(windowClientAreaX, windowClientAreaY);
            }
        }
    }

    private final Set<RegisteredElement> enteredElements = new HashSet<>();

    @Override
    public void move(int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : registeredElements) {
            var bounds = element.component().bounds();

            MouseInteraction interaction = element.interaction;
            if (isInside(windowClientAreaX, windowClientAreaY, bounds)) {
                if (!enteredElements.contains(element)) {
                    enteredElements.add(element);
                    interaction.mouseEnter(windowClientAreaX, windowClientAreaY);
                }
            } else {
                if (enteredElements.contains(element)) {
                    enteredElements.remove(element);
                    interaction.mouseExit(windowClientAreaX, windowClientAreaY);
                }
            }
        }
    }
}
