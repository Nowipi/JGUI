package nowipi.jgui.window.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEventDispatcher implements EventDispatcher {

    private final Map<Class<? extends Event>, List<EventListener<Event>>> listenerMap = new HashMap<>();

    public MapEventDispatcher() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public <EventType extends Event> void addListener(Class<EventType> eventClass, EventListener<EventType> listener) {
        listenerMap.putIfAbsent(eventClass, new ArrayList<>());
        listenerMap.get(eventClass).add((EventListener<Event>) listener);
    }

    @Override
    public <EventType extends Event> void removeListener(Class<EventType> eventClass, EventListener<EventType> listener) {
        if (listenerMap.containsKey(eventClass)) {
            listenerMap.get(eventClass).remove(listener);
        }
    }

    @Override
    public <EventType extends Event> void dispatch(Class<EventType> eventClass, EventType event) {
        if (listenerMap.containsKey(eventClass)) {
            listenerMap.get(eventClass).forEach((listener) -> listener.listen(event));
        }
    }
}
