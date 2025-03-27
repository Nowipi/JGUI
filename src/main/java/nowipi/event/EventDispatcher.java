package nowipi.event;

public interface EventDispatcher {

    <EventType extends Event> void addListener(Class<EventType> eventClass, EventListener<EventType> listener);

    <EventType extends Event> void removeListener(Class<EventType> eventClass, EventListener<EventType> listener);

    <EventType extends Event> void dispatch(Class<EventType> eventClass, EventType event);

}
