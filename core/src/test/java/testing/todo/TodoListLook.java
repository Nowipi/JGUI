package testing.todo;

import nowipi.jgui.Color;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.look.DrawCommand;

import java.util.List;

final class TodoListLook extends Container<ItemLook> {

    private final TodoList list;

    public TodoListLook(TodoList list) {
        super(Color.TRANSPARENT, FlowDirection.VERTICAL);
        this.list = list;
    }

    @Override
    public List<DrawCommand> draw() {
        clearChildren();
        for (Item item : list.items()) {
            addChild(new ItemLook(item));
        }
        return super.draw();
    }
}
