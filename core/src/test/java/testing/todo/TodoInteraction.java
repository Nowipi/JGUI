package testing.todo;

import nowipi.jgui.component.button.DefaultButtonInteraction;
import nowipi.jgui.component.checkbox.DefaultCheckboxInteraction;
import nowipi.jgui.component.textinput.DefaultTextInputInteraction;

final class TodoInteraction {

    public TodoInteraction(Todo todo) {
        DefaultTextInputInteraction textInputInteraction = new DefaultTextInputInteraction(todo.input());
        DefaultButtonInteraction buttonInteraction = new DefaultButtonInteraction(todo.addButton());

        for (Item item : todo.items().items()) {
            DefaultCheckboxInteraction checkboxInteraction = new DefaultCheckboxInteraction(item.checkbox());
        }
    }
}
