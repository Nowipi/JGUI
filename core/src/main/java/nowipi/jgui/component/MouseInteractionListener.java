package nowipi.jgui.component;

import nowipi.jgui.component.interaction.MouseInteraction;
import nowipi.jgui.input.mouse.Button;
import nowipi.jgui.window.event.WindowMouseListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            if (bounds.isInside(windowClientAreaX, windowClientAreaY)) {
                interaction.mousePress(windowClientAreaX, windowClientAreaY);
            }
        }
    }

    @Override
    public void release(Button button, int windowClientAreaX, int windowClientAreaY) {
        for (RegisteredElement element : new ArrayList<>(registeredElements)) {
            var bounds = element.component().bounds();

            MouseInteraction interaction = element.interaction;
            if (bounds.isInside(windowClientAreaX, windowClientAreaY)) {
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
            if (bounds.isInside(windowClientAreaX, windowClientAreaY)) {
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
