package nowipi.jgui.components;

import java.util.Collections;
import java.util.List;

public class Container implements Component {

    private final List<? extends Component> children;

    public Container(List<? extends Component> children) {
        this.children = children;
    }

    //Why no factory? Because this makes extending consistent with instancing
    public Container(Component ...children) {
        this(List.of(children));
    }

    public List<Component> children() {
        return Collections.unmodifiableList(children);
    }
}
