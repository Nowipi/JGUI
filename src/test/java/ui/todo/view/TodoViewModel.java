package ui.todo.view;

import ui.todo.model.CheckList;
import ui.todo.model.Item;

import java.util.ArrayList;
import java.util.List;

public final class TodoViewModel {

    private final CheckList model;
    private final List<ItemView> items;

    public TodoViewModel(CheckList checkList) {
        this.model = checkList;
        this.items = new ArrayList<>();
        refreshItems();
    }

    public void refreshItems() {
        items.clear();
        for (var item : model.items()) {
            items.add(new ItemView(new ItemViewModel(item)));
        }
    }

    public void addItem(String text) {
        model.add(new Item(text, false));
        refreshItems();
    }

    public List<ItemView> getItems() {
        return items;
    }
}
