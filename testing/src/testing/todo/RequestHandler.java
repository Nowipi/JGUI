package testing.todo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import nowipi.jgui.components.Component;
import nowipi.jgui.components.Interactable;
import nowipi.jgui.components.TextInput;
import nowipi.jgui.window.event.MapEventDispatcher;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

final class RequestHandler extends MapEventDispatcher implements HttpHandler {

    private final Component root;
    private final HTMLRenderer renderer;

    public RequestHandler(Component root, HTMLRenderer renderer) {
        this.root = root;
        this.renderer = renderer;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestMethod()) {
            case "GET" -> handleGet(exchange);
            case "POST" -> handlePost(exchange);
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestURI().getPath()) {
            case "/" -> {
                String response = "<!DOCTYPE html><html lang=\"en\"><head></head><body>" + renderer.render(root) + "<script src=\"/jgui.js\"></script></body></html>";
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
            case "/jgui.js" -> {
                byte[] content = ResourceUtils.getFileContents("jgui.js");
                exchange.sendResponseHeaders(200, content.length);
                try(OutputStream os = exchange.getResponseBody()) {
                    os.write(content);
                }
            }
            default -> System.out.println(exchange.getRequestURI().getPath());
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        var value = exchange.getRequestHeaders().get("Component-ID");
        if (value == null)
            return;
        UUID id = UUID.fromString(value.getFirst());

        //TODO change after interaction or change if the view changed, if so -> redirect page or even only update changed part.
        Component c = renderer.getComponent(id);
        if (c instanceof Interactable i) {
            i.interact();
        } else if (c instanceof TextInput t) {
            var body =new String(exchange.getRequestBody().readAllBytes());
            t.inputText(body);
        }
        exchange.sendResponseHeaders(204, -1);
    }
}
