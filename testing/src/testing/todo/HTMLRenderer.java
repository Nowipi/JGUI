package testing.todo;

import nowipi.jgui.components.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

final class HTMLRenderer {

    private final Map<UUID, Component> mappedComponents = new HashMap<>();

    public String render(Component component) {
        return switch (component) {
            case TextInput _ -> {
                var id = mapAndGetId(component);
                yield "<input type=\"text\" id='"+id+"'/>";
            }
            case Checkbox c -> {
                var id = mapAndGetId(component);
                yield "<input type=\"checkbox\" id=\""+id+"\" " + (c.checked() ? "checked" : "") + "/>";
            }
            case Container c -> renderContainer(c);
            case Text t -> t.text();
            default -> throw new IllegalStateException("Unexpected value: " + component);
        };
    }

    private UUID mapAndGetId(Component component) {
        var id = UUID.randomUUID();
        mappedComponents.put(id, component);
        return id;
    }

    public Component getComponent(UUID id) {
        return mappedComponents.get(id);
    }

    public String renderContainer(Container container) {
        String meta = "";
        String tag = switch (container) {
            case Button b -> {
                var id = mapAndGetId(b);
                meta = "id=\"" + id + "\"";
                yield "button";
            }
            default -> "div";
        };
        StringBuilder content = new StringBuilder("<" + tag + " " + meta + ">");
        for (Component child : container.children()) {
            content.append(render(child));
        }
        return content.append("</").append(tag).append(">").toString();
    }

}
