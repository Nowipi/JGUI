package nowipi.jgui.window;

public final class Mouse {

    private Mouse() {
    }

    public enum Button {
        LEFT, RIGHT, MIDDLE;

        private boolean pressed;

        public boolean isPressed() {
            return pressed;
        }

        public boolean isReleased() {
            return !pressed;
        }
    }


}
