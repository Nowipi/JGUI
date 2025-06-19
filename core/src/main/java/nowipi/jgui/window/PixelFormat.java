package nowipi.jgui.window;

public record PixelFormat(ColorSpace colorSpace, int colorBits,  int depthBits, int stencilBits) {

    public enum ColorSpace {
        RGBA
    }
}
