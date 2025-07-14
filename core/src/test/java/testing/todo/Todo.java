package testing.todo;

import nowipi.jgui.component.button.Button;
import nowipi.jgui.component.text.Text;
import nowipi.jgui.component.textinput.TextInput;

final class Todo {

    private final Text title;
    private final TodoList items;
    private final TextInput input;
    private final Button addButton;

    public Todo() {
        title = new Text("Todo App");
        items = new TodoList();
        input = new TextInput(100);
        addButton = new Button() {
            @Override
            public void click() {
                items.addItem(new Item(input.text()));
            }
        };
    }

    public Text title() {
        return title;
    }

    public Button addButton() {
        return addButton;
    }

    public TodoList items() {
        return items;
    }

    public TextInput input() {
        return input;
    }
}
