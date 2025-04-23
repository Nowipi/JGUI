package testing;

abstract sealed class Texture permits OpenGLTexture {

    public final int width;
    public final int height;
    public final byte[] data;

    public Texture(int width, int height, byte[] data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }
}
