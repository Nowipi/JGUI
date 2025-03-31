package ui.todo;

import nowipi.ui.components.Button;
import nowipi.ui.components.Container;
import ui.todo.model.CheckList;
import ui.todo.model.Item;
import ui.todo.view.TodoView;
import ui.todo.view.TodoViewModel;

final class TodoApp {

    public void start() {
        CheckList checklist = CheckList.from(
                new Item("skirt", true),
                new Item("foo", false),
                new Item("bar", false)
        );

        var viewModel = new TodoViewModel(checklist);
        var view = new TodoView(viewModel);

        checklist.add(new Item("Bombo", false));
        viewModel.refreshItems();
        ((Button)((Container)view.children().getFirst()).children().get(1)).interact();
        view.render();
    }

    public static void main(String[] args) {
        var app = new TodoApp();
        app.start();
    }

}
