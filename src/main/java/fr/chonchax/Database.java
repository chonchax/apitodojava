package fr.chonchax;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Dotenv dotenv;
    private String url;
    private String user;
    private String password;
    private Connection con;

    public Database() throws SQLException {
        this.dotenv = Dotenv.load();
        this.url = dotenv.get("DB_URL");
        this.user = dotenv.get("DB_USER");
        this.password = dotenv.get("DB_PASSWORD");

        try {
            this.con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la connexion à la db", e);
        }
    }

    public Connection getConnection() {
        return this.con;
    }
}
