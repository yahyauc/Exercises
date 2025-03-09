public class Chaussure extends Produit {
    private int pointure;

    public Chaussure(String nom, double prix, int pointure) {
        super(nom, prix);
        this.pointure = pointure;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Chaussure - Nom: " + nom + ", Prix: " + prix + " DH, Pointure: " + pointure);
    }
}
