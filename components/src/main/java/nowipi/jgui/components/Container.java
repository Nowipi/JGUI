package nowipi.jgui.components;

import nowipi.jgui.components.styling.ContainerLayout;
import nowipi.jgui.components.styling.Styling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Container extends Component {

    private final List<Component> children;
    public final ContainerLayout layout;

    public Container(Styling styling, ContainerLayout layout, List<Component> children) {
        super(styling, layout);
        this.children = children;
        this.layout = layout;
    }

    public Container(List<Component> children) {
        this(new Styling.Builder().build(), new ContainerLayout.Builder().build(), children);
    }

    public Container(ContainerLayout layout, List<Component> children) {
        this(new Styling.Builder().build(), layout, children);
    }

    public Container(Styling styling, ContainerLayout layout) {
        this(styling, layout, new ArrayList<>());
    }

    //Why no factory? Because this makes extending consistent with instancing
    public Container(Component ...children) {
        this(List.of(children));
    }

    public Container(Styling styling, Component ...children) {
        this(styling, new ContainerLayout.Builder().build(), List.of(children));
    }

    public Container(ContainerLayout layout, Component ...children) {
        this(layout, List.of(children));
    }

    public Container(Styling styling, ContainerLayout layout, Component ...children) {
        this(styling, layout, List.of(children));
    }

    public List<Component> children() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Component child) {
        children.add(child);
    }
}
