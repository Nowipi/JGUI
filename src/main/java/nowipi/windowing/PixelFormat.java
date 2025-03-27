package nowipi.windowing;

public record PixelFormat(ColorSpace colorSpace, int colorBits,  int depthBits, int stencilBits) {

    public enum ColorSpace {
        RGBA
    }
}
