package nowipi.jgui;

public class Font {

    private boolean italic;
    private boolean strikethrough;
    private boolean bold;
    private int size;

    public Font(int size) {
        this.size = size;
    }

    public int stringWidth(String text) {
        return size * text.length();
    }

    public boolean italic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean strikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    public boolean bold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
