package testing.todo;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.checkbox.Checkbox;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.text.Text;

final class Item extends Container {

    private final Checkbox checkbox;

    public Item(String text, Font font) {
        this(new Text(text, font, Color.WHITE));
    }

    private Item(Text text) {
        this(text, new Checkbox(text.font()) {
            @Override
            public void check() {
                text.font().setStrikethrough(true);
                text.setFont(text.font());
                super.check();
            }
        });
    }

    private Item(Text text, Checkbox checkbox) {
        super(Color.GREEN, FlowDirection.HORIZONTAL, text, checkbox);
        this.checkbox = checkbox;
    }

    Checkbox checkbox() {
        return checkbox;
    }
}
