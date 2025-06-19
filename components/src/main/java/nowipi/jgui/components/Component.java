package nowipi.jgui.components;

import nowipi.jgui.components.styling.Layout;
import nowipi.jgui.components.styling.Styling;

public abstract class Component {

    public final Styling styling;
    public final Layout layout;
    public float x;
    public float y;
    public float width;
    public float height;

    @SuppressWarnings("this-escape")
    public Component(Styling styling, Layout layout) {
        this.styling = styling;
        this.layout = layout;
        width = layout.size.width.calculate(this, null);
        height = layout.size.height.calculate(this, null);
    }

    @Override
    public String toString() {
        return "Component{" +
                "styling=" + styling +
                '}';
    }
}
