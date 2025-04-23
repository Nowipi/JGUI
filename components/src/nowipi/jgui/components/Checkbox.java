package nowipi.jgui.components;

public abstract class Checkbox extends Component implements Interactable {

    private boolean checked;

    public Checkbox(boolean checked) {
        this.checked = checked;
    }

    @Override
    public void interact() {
        checked = !checked;
        check();
    }

    protected abstract void check();

    public boolean checked() {
        return checked;
    }
}
