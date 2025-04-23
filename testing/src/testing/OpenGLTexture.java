package testing;

import static nowipi.jgui.opengl.OpenGL.*;

final class OpenGLTexture extends Texture {

    private final int id;

    public OpenGLTexture(int width, int height, byte[] data) {
        super(width, height, data);
        id = glGenTextures();

        bind();
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
        // set Texture wrap and filter modes
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        // unbind texture
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }
}
