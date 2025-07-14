package nowipi.jgui;

/*Immutable class because it's difficult to react to changes in a class that's used as a value based class*/
public record Font(boolean italic, boolean strikethrough, boolean bold, int size) {

    public int stringWidth(String text) {
        return size * text.length();
    }
}
