package fr.chonchax;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new ApiTodoHandler());
            server.start();

            System.out.println("J'ai démarré le serveur sur http://localhost:8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ApiTodoHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String reponse = "Serveur lancé !";
            exchange.sendResponseHeaders(200, reponse.length());
            OutputStream os = exchange.getResponseBody();
            os.write(reponse.getBytes());
            os.close();
        }
    }
}
