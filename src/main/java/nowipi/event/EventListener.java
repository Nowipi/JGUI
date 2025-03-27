package nowipi.event;

public interface EventListener<EventType> {

    void listen(EventType e);

}
