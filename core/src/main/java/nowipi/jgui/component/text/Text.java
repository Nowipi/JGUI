package nowipi.jgui.component.text;

import nowipi.jgui.component.Component;

public class Text implements Component {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
