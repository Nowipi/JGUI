package testing.todo;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.button.DefaultButtonLook;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.text.DefaultTextLook;
import nowipi.jgui.component.textinput.DefaultTextInputLook;

final class TodoLook extends Container<Look> {

    private static final Color BACKGROUND_COLOR = new Color(43, 42, 51, 255);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Font TITLE_FONT = new Font(false, false, false, 24);
    private static final Font BUTTON_FONT = new Font(false, false, false, 18);

    public TodoLook(Todo todo) {
        super(BACKGROUND_COLOR, FlowDirection.VERTICAL,
                new DefaultTextLook(todo.title(), TITLE_FONT, TEXT_COLOR),
                new DefaultTextInputLook(todo.input(), BUTTON_FONT, Color.RED, Color.WHITE),
                new DefaultButtonLook("Add", BUTTON_FONT, todo.addButton()),
                new TodoListLook(todo.items()));
    }

}