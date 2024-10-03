package fr.chonchax;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    static Dotenv dotenv = Dotenv.load();
    
    static String url = dotenv.get("DB_URL");
    static String user = dotenv.get("DB_USER");
    static String password = dotenv.get("DB_PASSWORD");
    Connection con;

    public Database() throws SQLException {
        try {
        this.con = DriverManager.getConnection(url, user, password);   
        System.out.println("J'ai connecté la db a mon app"); 
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la connexion à la db", e);
        }
    }

    public Connection getConnection() {
        return this.con;
    }
}
