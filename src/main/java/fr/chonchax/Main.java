package fr.chonchax;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Database db = new Database();

            db.getConnection();
            System.out.println("J'ai connecté la db a mon app");
        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion à la db");
            e.printStackTrace();
        }
    }
}