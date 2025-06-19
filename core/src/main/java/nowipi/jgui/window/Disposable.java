package nowipi.jgui.window;

public interface Disposable extends AutoCloseable {

    void dispose();

    @Override
    default void close() {
        dispose();
    }
}
