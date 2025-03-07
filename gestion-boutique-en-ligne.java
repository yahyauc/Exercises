import java.util.ArrayList;

abstract class Produit {
    protected String nom;
    protected double prix;
    protected String categorie;

    public Produit(String nom, double prix, String categorie) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }

    public abstract void afficherDetails();
}

class Vetement extends Produit {
    private String taille;

    public Vetement(String nom, double prix, String taille) {
        super(nom, prix, "Vêtement");
        this.taille = taille;
    }

    public void afficherDetails() {
        System.out.println("Vêtement - Nom: " + nom + ", Prix: " + prix + "€, Taille: " + taille);
    }
}

class Chaussure extends Produit {
    private int pointure;

    public Chaussure(String nom, double prix, int pointure) {
        super(nom, prix, "Chaussure");
        this.pointure = pointure;
    }

    public void afficherDetails() {
        System.out.println("Chaussure - Nom: " + nom + ", Prix: " + prix + "€, Pointure: " + pointure);
    }
}

class Accessoire extends Produit {
    private String type;

    public Accessoire(String nom, double prix, String type) {
        super(nom, prix, "Accessoire");
        this.type = type;
    }

    public void afficherDetails() {
        System.out.println("Accessoire - Nom: " + nom + ", Prix: " + prix + "€, Type: " + type);
    }
}

class Boutique {
    private ArrayList<Produit> produits = new ArrayList<>();

    public void ajouterProduit(Produit p) {
        produits.add(p);
    }

    public void afficherProduits() {
        for (Produit p : produits) {
            p.afficherDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Boutique boutique = new Boutique();

        boutique.ajouterProduit(new Vetement("T-shirt", 19.99, "M"));
        boutique.ajouterProduit(new Chaussure("Nike Air", 89.99, 42));
        boutique.ajouterProduit(new Accessoire("Montre", 49.99, "Luxe"));

        boutique.afficherProduits();
    }
}
