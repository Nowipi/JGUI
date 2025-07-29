package nowipi.jgui.rendering;

import nowipi.opengl.OpenGLGraphicsContext;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public final class OpenGLTexture {

    private final OpenGLGraphicsContext gc;

    private final int id;
    public final int width;
    public final int height;
    public final byte[] data;

    public OpenGLTexture(int width, int height, byte[] data, OpenGLGraphicsContext gc) {
        this.gc = gc;
        this.width = width;
        this.height = height;
        this.data = data;
        try(var arena = Arena.ofConfined()) {
            MemorySegment idPointer = arena.allocateFrom(ValueLayout.JAVA_INT, 0);
            gc.glGenTextures(1, idPointer);
            id = idPointer.get(ValueLayout.JAVA_INT, 0);

            bind();
            OpenGL.glTexImage2D(gc, OpenGL.GL_TEXTURE_2D, 0, OpenGL.GL_RGBA, width, height, 0, OpenGL.GL_RGBA, OpenGL.GL_UNSIGNED_BYTE, data);
        }


        // set Texture wrap and filter modes
        gc.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_WRAP_S, OpenGL.GL_REPEAT);
        gc.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_WRAP_T, OpenGL.GL_REPEAT);
        gc.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_MIN_FILTER, OpenGL.GL_LINEAR);
        gc.glTexParameteri(OpenGL.GL_TEXTURE_2D, OpenGL.GL_TEXTURE_MAG_FILTER, OpenGL.GL_LINEAR);

        unbind(gc);
    }

    public void bind() {
        gc.glBindTexture(OpenGL.GL_TEXTURE_2D, id);
    }

    public static void unbind(OpenGLGraphicsContext gc) {
        gc.glBindTexture(OpenGL.GL_TEXTURE_2D, 0);
    }
}
