package nowipi.jgui.components;

import nowipi.jgui.components.styling.Styling;

import java.util.Collections;
import java.util.List;

public class Container implements Component {

    private final List<? extends Component> children;
    private final Styling styling;

    public Container(List<? extends Component> children) {
        this(new Styling(), children);
    }

    public Container(Styling styling, List<? extends Component> children) {
        this.styling = styling;
        this.children = children;
    }

    //Why no factory? Because this makes extending consistent with instancing
    public Container(Component ...children) {
        this(List.of(children));
    }

    public Container(Styling styling, Component ...children) {
        this(styling, List.of(children));
    }

    public List<Component> children() {
        return Collections.unmodifiableList(children);
    }

    public Styling styling() {
        return styling;
    }
}
