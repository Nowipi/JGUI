package testing.todo;

import nowipi.jgui.component.checkbox.Checkbox;
import nowipi.jgui.component.text.Text;

final class Item {

    private final Checkbox checkbox;
    private final Text text;

    public Item(String text) {
        checkbox = new Checkbox();
        this.text = new Text(text);
    }

    Checkbox checkbox() {
        return checkbox;
    }

    Text text() {
        return text;
    }
}
