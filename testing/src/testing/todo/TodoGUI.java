package testing.todo;

import nowipi.jgui.components.*;

import java.util.List;

final class TodoGUI extends Container {

    public TodoGUI() {
        this(new InputField(), new TodoList());
    }

    private TodoGUI(InputField input, TodoList list) {
        super(
                new Text("Todo App"),
                input,
                new Button("Add", () -> list.addChild(new TodoList.TodoItem(input.text()))),
                list
        );
    }

    static final class Button extends InteractableContainer {
        public Button(String text, Runnable interact) {
            super(List.of(new Text(text)), interact);
        }
    }

    static final class TodoList extends Container {

        public TodoList() {
            super(
                    new TodoItem("Make todo app"),
                    new TodoItem("Create a wireframe"),
                    new TodoItem("Do something else")
            );
        }

        static final class TodoItem extends InteractableContainer {

            public TodoItem(String text) {
                this(new Text(text), Checkbox.newUnchecked());
            }

            private TodoItem(Text text, Checkbox checkbox) {
                super(List.of(text, checkbox), () -> {
                    text.style().setStrikethrough(true);
                    checkbox.setChecked(true);
                });
            }
        }
    }

    public static String getTree(Component component) {
        return getTree(component, 0);
    }

    private static String getTree(Component component, int depth) {
        String indent = "  ".repeat(depth);
        StringBuilder builder = new StringBuilder(indent).append(component).append(System.lineSeparator());

        if (component instanceof Container container) {
            for (Component child : container.children()) {
                builder.append(getTree(child, depth + 1));
            }
        }

        return builder.toString();
    }
}