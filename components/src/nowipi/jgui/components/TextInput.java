package nowipi.jgui.components;

public class TextInput implements Component{

    private final StringBuffer text = new StringBuffer();

    public String text() {
        return text.toString();
    }

    public void clear() {
        text.delete(0, text.length());
    }
}
