package nowipi.jgui;

public record Font(boolean italic, boolean strikethrough, boolean bold, int size) {

    public int stringWidth(String text) {
        return size * text.length();
    }

    public static class FontBuilder {
        private boolean italic, strikethrough, bold;
        private int size;

        public FontBuilder() {
        }

        private FontBuilder(boolean italic, boolean strikethrough, boolean bold, int size) {
            this.italic = italic;
            this.strikethrough = strikethrough;
            this.bold = bold;
            this.size = size;
        }

        public static FontBuilder from(Font font) {
            return new FontBuilder(font.italic(),  font.strikethrough(), font.bold(), font.size());
        }

        public FontBuilder italic(boolean italic) {
            this.italic = italic;
            return this;
        }

        public FontBuilder strikethrough(boolean strikethrough) {
            this.strikethrough = strikethrough;
            return this;
        }

        public FontBuilder bold(boolean bold) {
            this.bold = bold;
            return this;
        }

        public FontBuilder size(int size) {
            this.size = size;
            return this;
        }

        public Font build() {
            return new Font(italic, strikethrough, bold, size);
        }

    }

}
