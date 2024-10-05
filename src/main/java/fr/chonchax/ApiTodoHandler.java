package fr.chonchax;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;

public class ApiTodoHandler implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        String reponse = "Serveur lancé !";

        exchange.sendResponseHeaders(200, reponse.length());

        OutputStream os = exchange.getResponseBody();

        os.write(reponse.getBytes());
        os.close();
    }
    
}