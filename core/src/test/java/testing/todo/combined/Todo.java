package testing.todo.combined;

import nowipi.jgui.component.Component;
import nowipi.jgui.component.button.Button;
import nowipi.jgui.component.text.Text;
import nowipi.jgui.component.textinput.TextInput;

import java.util.ArrayList;
import java.util.List;

final class Todo implements Component {

    private final Text title;
    private final TextInput todoInput;
    private final Button addButton;
    private final List<Item> items = new ArrayList<>();

    public Todo() {
        this.title = new Text("Todo App");
        this.todoInput = new TextInput();
        todoInput.input('b');
        todoInput.input('o');
        todoInput.input('b');
        this.addButton = new Button() {
            @Override
            public void click() {
                addItem(new Item(todoInput.input()));
            }
        };
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public Text title() {
        return title;
    }

    public TextInput todoInput() {
        return todoInput;
    }

    public Button addButton() {
        return addButton;
    }

    public List<Item> items() {
        return items;
    }
}
