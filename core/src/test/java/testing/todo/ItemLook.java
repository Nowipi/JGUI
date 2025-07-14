package testing.todo;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.checkbox.DefaultCheckboxLook;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.text.DefaultTextLook;

import java.util.List;

final class ItemLook extends Container<Look> {

    private final Item item;
    private final DefaultCheckboxLook checkboxLook;
    private final DefaultTextLook textLook;

    public ItemLook(Item item) {
        this(item, new Font(false, false, false, 18));
    }

    private ItemLook(Item item, Font font) {
        this(item, new DefaultCheckboxLook(item.checkbox(), font), new DefaultTextLook(item.text(), font, Color.BLACK));
    }

    private ItemLook(Item item, DefaultCheckboxLook checkboxLook, DefaultTextLook textLook) {
        super(Color.TRANSPARENT, FlowDirection.HORIZONTAL,
                checkboxLook,
                textLook
        );

        this.item = item;
        this.checkboxLook = checkboxLook;
        this.textLook = textLook;
    }

    @Override
    public List<DrawCommand> draw() {
        var textFont = textLook.font();
        var checkboxFont = checkboxLook.font();
        boolean isChecked = item.checkbox().isChecked();
        textLook.setFont(new Font(textFont.italic(), isChecked, textFont.bold(), textFont.size()));
        checkboxLook.setFont(new Font(checkboxFont.italic(), isChecked, checkboxFont.bold(), checkboxFont.size()));
        return super.draw();
    }
}
