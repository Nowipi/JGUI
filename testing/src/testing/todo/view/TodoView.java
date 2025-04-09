package testing.todo.view;

import nowipi.jgui.components.*;

public final class TodoView extends Container {

    public TodoView(TodoViewModel viewModel) {
        super(
                AddItemView(viewModel),
                CheckListView(viewModel)
        );
    }

    private static Component AddItemView(TodoViewModel viewModel) {
        TextInput textInput = new TextInput();
        return new Container(
                textInput,
                new Button(new Text("Add Item")) {
                    @Override
                    public void interact() {
                        viewModel.addItem(textInput.text());
                        textInput.clear();
                    }
                }
        );
    }

    private static Component CheckListView(TodoViewModel viewModel) {
        return new Container(viewModel.getItems());
    }

}
