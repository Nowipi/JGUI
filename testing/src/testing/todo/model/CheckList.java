package testing.todo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CheckList {

    private final List<Item> items;

    public CheckList() {
        this(new ArrayList<>());
    }

    public CheckList(List<Item> items) {
        this.items = items;
    }

    public static CheckList from(Item...item) {
        return new CheckList(new ArrayList<>(List.of(item)));
    }

    public void add(Item item) {
        items.add(item);
        System.out.println("added: " + item);
    }

    public List<Item> items() {
        return Collections.unmodifiableList(items);
    }
}
