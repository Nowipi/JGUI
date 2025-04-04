package testing.todo.view;

import testing.todo.model.Item;

public final class ItemViewModel {

    private final Item model;

    public ItemViewModel(Item model) {
        this.model = model;
    }

    public String itemName() {
        return model.name();
    }

    public boolean itemChecked() {
        return model.done();
    }

    public void checkItem(boolean checked) {
        model.setDone(checked);
    }
}
