package fr.chonchax;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Server server = new Server();
            System.out.println("J'ai lancé mon serveur");
            server.start();

            Database db = new Database();
            System.out.println("J'ai connecté la db a mon app");
            db.getConnection();

        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion à la db");
            e.printStackTrace();
        }
    }
}