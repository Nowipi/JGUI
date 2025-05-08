package nowipi.jgui.components;

public class Text extends Component {

    private String text;
    private Style style;

    public Text(String text) {
        this.text = text;
        style = new Style();
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Style style() {
        return style;
    }

    public static class Style extends nowipi.jgui.components.Style {
        private boolean strikethrough;
        private boolean bold;

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

        @Override
        public String toString() {
            return "Style{" +
                    "strikethrough=" + strikethrough +
                    ", bold=" + bold +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                ", style=" + style +
                '}';
    }
}
