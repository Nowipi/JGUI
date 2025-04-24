package nowipi.jgui.rendering;

import nowipi.opengl.OpenGL;

public final class OpenGLTexture {

    private final int id;
    public final int width;
    public final int height;
    public final byte[] data;

    public OpenGLTexture(int width, int height, byte[] data) {
        this.width = width;
        this.height = height;
        this.data = data;
        id = OpenGL.glGenTextures();

        bind();
        OpenGL.glTexImage2D(OpenGL.GL_TEXTURE_2D, 0, OpenGL.GL_RGBA, width, height, 0, OpenGL.GL_RGBA, OpenGL.GL_UNSIGNED_BYTE, data);
        // set Texture wrap and filter modes
        OpenGL.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_WRAP_S, OpenGL.GL_REPEAT);
        OpenGL.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_WRAP_T, OpenGL.GL_REPEAT);
        OpenGL.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_MIN_FILTER, OpenGL.GL_LINEAR);
        OpenGL.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_MAG_FILTER, OpenGL.GL_LINEAR);

        unbind();
    }

    public void bind() {
        OpenGL.glBindTexture(OpenGL.GL_TEXTURE_2D, id);
    }

    public static void unbind() {
        OpenGL.glBindTexture(OpenGL.GL_TEXTURE_2D, 0);
    }
}
