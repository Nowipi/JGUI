package nowipi.windowing.event;

import nowipi.event.Event;

public record WindowResizeEvent(int width, int height) implements Event {


}
