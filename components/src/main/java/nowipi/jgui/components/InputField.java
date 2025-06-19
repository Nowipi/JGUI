package nowipi.jgui.components;

import nowipi.jgui.components.styling.Color;
import nowipi.jgui.components.styling.ContainerLayout;
import nowipi.jgui.components.styling.Styling;

public class InputField extends Component {

    private final StringBuffer text = new StringBuffer();

    public InputField() {
        super(new Styling.Builder()
                .backgroundColor(Color.YELLOW)
                .build(),
                new ContainerLayout.Builder()
                        .build()
        );
    }

    public String text() {
        return text.toString();
    }

    public void clear() {
        text.delete(0, text.length());
    }

    public void inputText(String text) {
        clear();
        this.text.append(text);
    }

    @Override
    public String toString() {
        return "InputField{" +
                "text=" + text +
                '}';
    }
}
