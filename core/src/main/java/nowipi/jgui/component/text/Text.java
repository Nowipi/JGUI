package nowipi.jgui.component.text;

import nowipi.jgui.component.Component;

public class Text implements Component {

    private String string;

    public Text(String string) {
        this.string = string;
    }

    public String string() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
