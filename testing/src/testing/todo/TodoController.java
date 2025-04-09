package testing.todo;

import com.sun.net.httpserver.HttpExchange;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TodoController {


    public void get(HttpExchange exchange) {
        try (FileInputStream fis = new FileInputStream(exchange.getRequestURI().getPath());
             FileChannel fc = fis.getChannel()) {
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

            exchange.sendResponseHeaders(200, fc.size());
            try(OutputStream os = exchange.getResponseBody()) {
                os.write(bb.array());
            }
        } catch (FileNotFoundException e) {
            try {
                exchange.sendResponseHeaders(404, -1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
