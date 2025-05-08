package nowipi.jgui.components;

import nowipi.jgui.components.styling.Layout;
import nowipi.jgui.components.styling.Styling;

import java.util.Collections;
import java.util.List;

public class Container extends Component {

    private final List<Component> children;
    public final Layout layout;

    public Container(List<Component> children) {
        layout = new Layout.Builder().build();
        this.children = children;
    }

    public Container(Styling styling, Layout layout, List<Component> children) {
        super(styling);
        this.layout = layout;
        this.children = children;
    }

    public Container(Layout layout, List<Component> children) {
        this.layout = layout;
        this.children = children;
    }

    //Why no factory? Because this makes extending consistent with instancing
    public Container(Component ...children) {
        this(List.of(children));
    }

    public Container(Styling styling, Component ...children) {
        this(styling, new Layout.Builder().build(), List.of(children));
    }

    public Container(Layout layout, Component ...children) {
        this(layout, List.of(children));
    }

    public Container(Styling styling, Layout layout, Component ...children) {
        this(styling, layout, List.of(children));
    }

    public List<Component> children() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Component child) {
        children.add(child);
    }
}
