package nowipi.jgui.rendering;

import nowipi.jgui.window.Window;
import nowipi.jgui.windows.window.Win32Window;
import nowipi.opengl.GraphicsContext;
import nowipi.opengl.OpenGLGraphicsContext;
import nowipi.opengl.win32.WGLGraphicsContext;
import nowipi.opengl.win32.WGLGraphicsContextExtensionImpl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static nowipi.opengl.win32.WGLGraphicsContext.*;
import static nowipi.opengl.win32.WGLGraphicsContext.WGL_CONTEXT_CORE_PROFILE_BIT_ARB;
import static nowipi.opengl.win32.WGLGraphicsContext.WGL_CONTEXT_FLAGS_ARB;

public final class OpenGL extends nowipi.opengl.OpenGL {

    private OpenGL() {}

    public enum Profile {
        CORE,
        COMPATIBILITY
    }

    public static OpenGLGraphicsContext createGraphicsContext(Window window) {
        switch (window) {
            case Win32Window win32Window -> {
                return new WGLGraphicsContextExtensionImpl(win32Window.deviceContext().handle());
            }
            default -> throw new IllegalStateException("Unexpected value: " + window);
        }
    }

    public static OpenGLGraphicsContext createGraphicsContext(Window window, int majorVersion, int minorVersion, Profile profile) {
        switch (window) {
            case Win32Window win32Window -> {
                WGLGraphicsContext gc =  new WGLGraphicsContextExtensionImpl(win32Window.deviceContext().handle());
                int profileMask = switch (profile) {
                    case CORE -> WGL_CONTEXT_CORE_PROFILE_BIT_ARB;
                    case COMPATIBILITY -> WGL_CONTEXT_COMPATIBILITY_PROFILE_BIT_ARB;
                };
                gc.setAttributes(new int[] {
                        WGL_CONTEXT_MAJOR_VERSION_ARB, majorVersion,
                        WGL_CONTEXT_MINOR_VERSION_ARB, minorVersion,
                        WGL_CONTEXT_PROFILE_MASK_ARB, profileMask,
                        WGL_CONTEXT_FLAGS_ARB, 0,
                        0
                });
                return gc;
            }
            default -> throw new IllegalStateException("Unexpected value: " + window);
        }
    }

    public static void glShaderSource(OpenGLGraphicsContext gc, int shader, String str) {
        try (var arena = Arena.ofConfined()) {
            gc.glShaderSource(shader, 1, arena.allocateFrom(ValueLayout.ADDRESS, arena.allocateFrom(str)), arena.allocateFrom(ValueLayout.JAVA_INT,
                    str.length()));
        }
    }

    public static int glGenVertexArray(OpenGLGraphicsContext gc) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment VAOP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGenVertexArrays(1, VAOP);
            return VAOP.get(ValueLayout.JAVA_INT, 0);
        }
    }

    public static void glDeleteVertexArray(OpenGLGraphicsContext gc, int vertexArray) {
        try (var arena = Arena.ofConfined()) {
            gc.glDeleteVertexArrays(1, arena.allocateFrom(ValueLayout.JAVA_INT, vertexArray));
        }
    }

    public static void glDeleteBuffer(OpenGLGraphicsContext gc, int buffer) {
        try (var arena = Arena.ofConfined()) {
            gc.glDeleteBuffers(1, arena.allocateFrom(ValueLayout.JAVA_INT, buffer));
        }
    }

    public static int glGenBuffer(OpenGLGraphicsContext gc) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment BOP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGenBuffers(1, BOP);
            return BOP.get(ValueLayout.JAVA_INT, 0);
        }
    }

    public static void glBufferData(OpenGLGraphicsContext gc, int target, float[] data, int usage) {
        try (var arena = Arena.ofConfined()) {
            gc.glBufferData(target, (long) data.length * Float.BYTES, arena.allocateFrom(ValueLayout.JAVA_FLOAT, data), usage);
        }
    }

    public static void glBufferData(OpenGLGraphicsContext gc, int target, int[] data, int usage) {
        try (var arena = Arena.ofConfined()) {
            gc.glBufferData(target, (long) data.length * Integer.BYTES, arena.allocateFrom(ValueLayout.JAVA_INT, data), usage);
        }
    }

    public static boolean glGetShaderCompileStatus(OpenGLGraphicsContext gc, int shader) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment successP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGetShaderiv(shader, GL_COMPILE_STATUS, successP);
            if (successP.get(ValueLayout.JAVA_INT, 0) == GL_TRUE) {
                return true;
            } else if (successP.get(ValueLayout.JAVA_INT, 0) == GL_FALSE) {
                return false;
            } else {
                throw new RuntimeException("Shader compile status is neither true or false.");
            }
        }
    }

    public static String glGetShaderInfoLog(OpenGLGraphicsContext gc, int shader, int maxByteSize) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment infoLog = arena.allocate(maxByteSize);
            gc.glGetShaderInfoLog(shader, maxByteSize, MemorySegment.NULL, infoLog);
            return infoLog.getString(0);
        }
    }

    public static boolean glGetProgramLinkStatus(OpenGLGraphicsContext gc, int program) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment successP = arena.allocate(ValueLayout.JAVA_INT);
            gc.glGetProgramiv(program, GL_LINK_STATUS, successP);
            if (successP.get(ValueLayout.JAVA_INT, 0) == GL_TRUE) {
                return true;
            } else if (successP.get(ValueLayout.JAVA_INT, 0) == GL_FALSE) {
                return false;
            } else {
                throw new RuntimeException("Program link status is neither true or false.");
            }
        }
    }

    public static String glGetProgramInfoLog(OpenGLGraphicsContext gc, int program, int maxByteSize) {
        try (var arena = Arena.ofConfined()) {
            MemorySegment infoLog = arena.allocate(maxByteSize);
            gc.glGetProgramInfoLog(program, maxByteSize, MemorySegment.NULL, infoLog);
            return infoLog.getString(0);
        }
    }

    public static int glGetUniformLocation(OpenGLGraphicsContext gc, int shader, String name) {
        try (var arena = Arena.ofConfined()) {
            return gc.glGetUniformLocation(shader, arena.allocateFrom(name));
        }
    }

    public static byte toGL_BOOL(boolean b) {
        return b ? GL_TRUE : GL_FALSE;
    }

    public static void glUniformMatrix4fv(OpenGLGraphicsContext gc, int location, boolean transpose, float[] matrix) {
        try (var arena = Arena.ofConfined()) {
            gc.glUniformMatrix4fv(location, 1, toGL_BOOL(transpose), arena.allocateFrom(ValueLayout.JAVA_FLOAT, matrix));
        }
    }

    public static void glTexImage2D(OpenGLGraphicsContext gc, int target, int level, int internalformat, int width, int height, int border, int format, int type, byte[] data) {
        try (var arena = Arena.ofConfined()) {
            gc.glTexImage2D(target, level, internalformat, width, height, border, format, type, arena.allocateFrom(ValueLayout.JAVA_BYTE, data));
        }
    }
}
