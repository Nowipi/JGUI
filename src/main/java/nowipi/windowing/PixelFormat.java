package nowipi.windowing;

//TODO make it os independent
public record PixelFormat(ColorSpace colorSpace, int colorBits,  int depthBits, int stencilBits) {

    public enum ColorSpace {
        RGBA
    }
}
