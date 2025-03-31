package nowipi.ui.components;

import java.util.List;

public abstract class Button extends Container implements Interactable {
    public Button(Component child) {
        super(List.of(child));
    }
}
