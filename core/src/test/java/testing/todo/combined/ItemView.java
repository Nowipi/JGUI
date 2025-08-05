package testing.todo.combined;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.checkbox.CheckboxLook;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.text.TextLook;

final class ItemView extends Container<Item> {

    private static final Color BACKGROUND_COLOR = Color.GREEN;
    private static final Font FONT = new Font(16);

    private final TextLook text;
    private final CheckboxLook checkbox;

    public ItemView(Item item) {
        this(new TextLook(FONT, Color.WHITE), new CheckboxLook(FONT), item);
    }

    private ItemView(TextLook text, CheckboxLook checkbox, Item item) {
        super(FlowDirection.HORIZONTAL,
                text.bounds(item.text()),
                checkbox.bounds(item.checkbox()));
        this.text = text;
        this.checkbox = checkbox;
    }

    @Override
    public void draw(Item item, ComponentRenderer renderer) {
        renderer.drawQuad(bounds(item), BACKGROUND_COLOR);
        text.draw(item.text(), renderer);
        checkbox.draw(item.checkbox(), renderer);
    }

    public CheckboxLook checkbox() {
        return checkbox;
    }
}
