package nowipi.jgui.components;

import nowipi.jgui.components.styling.Styling;

public abstract class Component {

    public final Styling styling;

    public Component(Styling styling) {
        this.styling = styling;
    }

    public Component() {
        styling = new Styling.Builder().build();
    }

    public Styling styling() {
        return styling;
    }
}
