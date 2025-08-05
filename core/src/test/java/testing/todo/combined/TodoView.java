package testing.todo.combined;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.MouseInteractionListener;
import nowipi.jgui.component.button.ButtonLook;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.text.TextLook;
import nowipi.jgui.component.textinput.TextInputLook;

import java.util.HashMap;
import java.util.Map;

final class TodoView extends Container<Todo> {

    private static final Font FONT = new Font(16);

    private final TextLook title;
    private final TextInputLook input;
    private final ButtonLook addButton;
    private final Map<Item, ItemView> items;
    private final MouseInteractionListener mouseInteractionListener = new MouseInteractionListener();

    public TodoView(Todo todo) {
        this(new TextLook(FONT, Color.BLACK),
                new TextInputLook(FONT, Color.WHITE, Color.BLACK),
                new ButtonLook("Add", FONT),
                todo);
    }

    private TodoView(TextLook title, TextInputLook input, ButtonLook addButton, Todo todo) {
        super(FlowDirection.VERTICAL,
                title.bounds(todo.title()),
                input.bounds(todo.todoInput()),
                addButton.bounds(todo.addButton()));
        this.title = title;
        this.input = input;
        this.addButton = addButton;
        mouseInteractionListener.registerElement(todo.addButton(), addButton, todo.addButton());
        items = new HashMap<>();
    }

    @Override
    public void draw(Todo todo, ComponentRenderer renderer) {

        renderer.drawQuad(bounds(todo), Color.WHITE);

        title.draw(todo.title(), renderer);
        input.draw(todo.todoInput(), renderer);
        addButton.draw(todo.addButton(), renderer);

        for (Item item : todo.items()) {
            ItemView look = items.get(item);
            if (look == null) {
                look = new ItemView(item);
                items.put(item, look);
                addBounds(look.bounds(item));
                mouseInteractionListener.registerElement(item.checkbox(), look.checkbox(), item.checkbox());
            }

            look.draw(item, renderer);
        }

    }

    public MouseInteractionListener mouseInteractionListener() {
        return mouseInteractionListener;
    }
}
