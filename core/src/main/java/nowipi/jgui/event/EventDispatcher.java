package nowipi.jgui.event;

import java.util.function.Consumer;

public interface EventDispatcher<EventType extends EventListener> {

    void addListener(EventType listener);

    void removeListener(EventType listener);

    void dispatch(Consumer<EventType> dispatch);

}
