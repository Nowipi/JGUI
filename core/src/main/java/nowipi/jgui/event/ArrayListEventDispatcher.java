package nowipi.jgui.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListEventDispatcher<EventType extends EventListener> implements EventDispatcher<EventType> {

    private final List<EventType> listeners = new ArrayList<>();

    public ArrayListEventDispatcher() {
    }

    @Override
    public void addListener(EventType listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventType listener) {
        listeners.remove(listener);
    }

    @Override
    public void dispatch(Consumer<EventType> dispatch) {
        for (EventType listener : listeners) {
            dispatch.accept(listener);
        }
    }
}
