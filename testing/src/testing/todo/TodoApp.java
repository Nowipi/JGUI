package testing.todo;

import com.sun.net.httpserver.HttpServer;
import nowipi.jgui.components.*;
import testing.todo.model.CheckList;
import testing.todo.model.Item;
import testing.todo.view.TodoView;
import testing.todo.view.TodoViewModel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;

final class TodoApp {

    public void start() throws IOException, NoSuchAlgorithmException {
        CheckList checklist = CheckList.from(
                new Item("skirt", true),
                new Item("foo", false),
                new Item("bar", false)
        );

        var viewModel = new TodoViewModel(checklist);
        var view = new TodoView(viewModel);


        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0, "/", new RequestHandler(view, new HTMLRenderer()));

        server.start();

    }

    public static void main(String[] args) {
        var app = new TodoApp();
        try {
            app.start();
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
