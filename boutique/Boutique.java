import java.util.ArrayList;

public class Boutique {
    private ArrayList<Produit> produits;

    public Boutique() {
        produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit p) {
        produits.add(p);
    }

    public void afficherProduits() {
        for (Produit p : produits) {
            p.afficherDetails();
        }
    }

    public static void main(String[] args) {
        Boutique boutique = new Boutique();

        Vetement v1 = new Vetement("Chemise", 150.0, "M");
        Chaussure c1 = new Chaussure("Bottes", 250.0, 40);
        Accessoire a1 = new Accessoire("Montre", 300.0, "Métal");
        Vetement v2 = new Vetement("Veste imperméable", 400.0, "XXL");

        boutique.ajouterProduit(v1);
        boutique.ajouterProduit(c1);
        boutique.ajouterProduit(a1);
        boutique.ajouterProduit(v2);

        boutique.afficherProduits();
    }
}
