package nowipi.jgui.component.textinput;

import nowipi.jgui.component.Component;
import nowipi.jgui.component.interaction.KeyboardInteraction;
import nowipi.jgui.component.interaction.MouseInteraction;
import nowipi.jgui.input.keyboard.Key;

import java.util.LinkedList;

public class TextInput implements Component, MouseInteraction, KeyboardInteraction {

    private final LinkedList<Character> characters;
    private int cursor;
    private Selection selection;

    private static class Selection {
        private final int start;
        private int end;

        public Selection(int start) {
            this.start = start;
        }

        public int start() {
            return start;
        }

        public int end() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public TextInput() {
        characters = new LinkedList<>();
    }


    public void input(char character) {
        characters.add(cursor++, character);
    }

    public String input() {
        char[] array = new char[characters.size()];
        for (int i = 0; i < array.length; i++) {
            char character = characters.get(i);
            array[i] = character;
        }
        return new String(array);
    }

    public void setCursor(int location) {
        if (location < 0 ||  location > characters.size()) {
            throw new IndexOutOfBoundsException("Invalid cursor location " + cursor);
        }

        if (selection != null) {
            selection.setEnd(location);
        }
        cursor = location;
    }

    public void setCursorToEnd() {
        setCursor(characters.size());
    }

    public int cursor() {
        return cursor;
    }

    public void delete() {
        if (selection != null) {
            characters.subList(Math.min(selection.start(), selection.end()), Math.max(selection.start(), selection.end())).clear();

        } else {
            if (cursor > 0) {
                characters.remove(cursor - 1);
            }
        }
    }

    public void select() {
        selection = new Selection(cursor);
    }

    public void deselect() {
        selection = null;
    }

    @Override
    public void mouseEnter(int screenX, int screenY) {

    }

    @Override
    public void mouseExit(int screenX, int screenY) {

    }

    @Override
    public void mousePress(int screenX, int screenY) {
        setCursor(mouseLocationToIndex(screenX, screenY));
    }

    private int mouseLocationToIndex(int screenX, int screenY) {
        //TODO look needed for this
        return 0;
    }

    @Override
    public void mouseRelease(int screenX, int screenY) {

    }

    @Override
    public void keyPress(Key key) {

        switch (key) {
            case DELETE:
                delete();
                break;
            default:
                input((char) key.ordinal());
        }
    }

    @Override
    public void keyRelease(Key key) {

    }
}
