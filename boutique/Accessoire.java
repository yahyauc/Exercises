public class Accessoire extends Produit {
    private String type;

    public Accessoire(String nom, double prix, String type) {
        super(nom, prix);
        this.type = type;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Accessoire - Nom: " + nom + ", Prix: " + prix + " DH, Type: " + type);
    }
}
