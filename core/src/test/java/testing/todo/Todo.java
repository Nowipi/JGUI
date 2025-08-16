package testing.todo;

import nowipi.jgui.Color;
import nowipi.jgui.Font;
import nowipi.jgui.component.MouseInteractionListener;
import nowipi.jgui.component.button.Button;
import nowipi.jgui.component.container.Container;
import nowipi.jgui.component.container.FlowDirection;
import nowipi.jgui.component.text.Text;
import nowipi.jgui.component.textinput.TextInput;


final class Todo extends Container {

    private static final Font FONT = new Font.FontBuilder().size(16).build();

    private final TextInput itemTextInput;
    private final MouseInteractionListener listener;

    public Todo() {
        this(new Text("Todo App", FONT, Color.BLACK), new TextInput(FONT, Color.WHITE, Color.BLACK));

        Button addButton = new Button("click me!", FONT) {
            @Override
            public void click() {
                addItem(itemTextInput.input());
            }
        };
        addChild(addButton);
        listener.registerElement(addButton, addButton);
    }

    private Todo(Text title, TextInput itemTextInput) {
        super(Color.WHITE, FlowDirection.VERTICAL, title, itemTextInput);
        this.itemTextInput = itemTextInput;
        itemTextInput.input('b');
        itemTextInput.input('o');
        itemTextInput.input('b');
        listener = new MouseInteractionListener();
    }

    public void addItem(String text) {
        var item = new Item(text, FONT);
        addChild(item);
        listener.registerElement(item.checkbox(), item.checkbox());
    }


    public MouseInteractionListener mouseInteractionListener() {
        return listener;
    }
}
