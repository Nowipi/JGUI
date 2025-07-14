package testing.todo;

import java.util.ArrayList;
import java.util.List;

final class TodoList {

    private final List<Item> items;

    public TodoList() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> items() {
        return items;
    }
}
