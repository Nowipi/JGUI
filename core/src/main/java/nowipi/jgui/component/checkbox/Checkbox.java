package nowipi.jgui.component.checkbox;

public class Checkbox {

    private boolean checked = false;

    public void check() {
        checked = !checked;
    }

    public boolean isChecked() {
        return checked;
    }
}
