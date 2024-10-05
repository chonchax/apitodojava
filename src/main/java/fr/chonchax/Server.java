package fr.chonchax;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    public void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);

            server.createContext("/", new ApiTodoHandler());
            server.createContext("/users", new UserHandler()); 
            server.createContext("/todos", new TodoHandler());   
            server.start();

            System.out.println("J'ai démarré le serveur sur http://localhost:8081");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Une erreur est survenue...");
            e.printStackTrace();
        }
    }
}
