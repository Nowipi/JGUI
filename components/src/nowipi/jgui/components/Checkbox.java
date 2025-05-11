package nowipi.jgui.components;

import nowipi.jgui.components.styling.Layout;
import nowipi.jgui.components.styling.Styling;

public class Checkbox extends Component {

    private boolean checked;

    public Checkbox(boolean checked) {
        super(new Styling.Builder().build(), new Layout.Builder<>().build());
        this.checked = checked;
    }

    public static Checkbox newUnchecked() {
        return new Checkbox(false);
    }

    public boolean checked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Checkbox{" +
                "checked=" + checked +
                '}';
    }
}
