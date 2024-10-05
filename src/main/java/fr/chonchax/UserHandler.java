package fr.chonchax;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class UserHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            List<User> users = new ArrayList<>();
    
            try {

                Database db = new Database();
                Connection con = db.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user");
    
                while (rs.next()) {
                    User user = new User(
                        rs.getInt("id"), 
                        rs.getString("email"), 
                        rs.getString("name"), 
                        rs.getString("firstname"), 
                        rs.getTimestamp("created_at")
                    );
                    users.add(user);
                }
    
                rs.close();
                stmt.close();
                con.close();
    
            } catch (Exception e) {
                e.printStackTrace();
                String errorResponse = "Erreur: " + e.getMessage();
                exchange.sendResponseHeaders(500, errorResponse.length());
                OutputStream os = exchange.getResponseBody();
                os.write(errorResponse.getBytes());
                os.close();
                return;
            }

            Gson gson = new Gson();
            String jsonResponse = gson.toJson(users);


            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsonResponse.length());
            OutputStream os = exchange.getResponseBody();
            os.write(jsonResponse.getBytes());
            os.close();
        } else {

            String response = "Méthode non autorisée!";
            exchange.sendResponseHeaders(405, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
