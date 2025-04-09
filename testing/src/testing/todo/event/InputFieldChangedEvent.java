package testing.todo.event;

import nowipi.jgui.window.event.Event;

public record InputFieldChangedEvent(String newText) implements Event {
}
