package nowipi.jgui.components;

public class InputField extends Component {

    private final StringBuffer text = new StringBuffer();

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
