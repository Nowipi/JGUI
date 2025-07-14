package nowipi.jgui.component.textinput;

import nowipi.jgui.component.Component;

public class TextInput implements Component {

    private final char[] characters;
    private int cursor;

    public TextInput(int maxChars) {
        characters = new char[maxChars];
    }

    public boolean addChar(char character) {
        if (cursor == characters.length) {
            return false;
        }
        characters[cursor++] = character;
        return true;
    }

    public String text() {
        return new String(characters, 0, cursor);
    }

}
