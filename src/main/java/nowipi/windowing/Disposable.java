package nowipi.windowing;

public interface Disposable extends AutoCloseable {

    void dispose();

    @Override
    default void close() {
        dispose();
    }
}
