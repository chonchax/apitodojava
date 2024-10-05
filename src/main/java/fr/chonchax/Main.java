package fr.chonchax;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Server server = new Server();
            server.start();
            System.out.println("J'ai lancé mon serveur");

            Database db = new Database();
            db.getConnection();
            System.out.println("J'ai connecté la db a mon app");

        } catch (Exception e) {
            System.out.println("Une erreur est survenue...");
            e.printStackTrace();
        }
    }
}