package testing.todo.combined;

import nowipi.jgui.component.Component;
import nowipi.jgui.component.checkbox.Checkbox;
import nowipi.jgui.component.text.Text;

final class Item implements Component {

    private final Checkbox checkbox;
    private final Text text;

    public Item(String text) {
        this(new Text(text), new Checkbox() {
            @Override
            public void check() {
                super.check();
            }
        });
    }

    private Item(Text text, Checkbox checkbox) {
        this.checkbox = checkbox;
        this.text = text;
    }

    Checkbox checkbox() {
        return checkbox;
    }

    Text text() {
        return text;
    }
}
