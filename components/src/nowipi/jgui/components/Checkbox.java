package nowipi.jgui.components;

public class Checkbox extends Component {

    private boolean checked;

    public Checkbox(boolean checked) {
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
