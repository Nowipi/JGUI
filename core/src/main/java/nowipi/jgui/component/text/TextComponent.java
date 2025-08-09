package nowipi.jgui.component.text;

import nowipi.jgui.component.Component;

public abstract class TextComponent implements Component {

    private String string;

    public TextComponent(String string) {
        this.string = string;
    }

    public String string() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
        //TODO update size of every component with this look
    }
}
