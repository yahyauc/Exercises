class Produit {
    String numeroSerie;
    double prix;

    public Produit(String numeroSerie, double prix) {
        this.numeroSerie = numeroSerie;
        this.prix = prix;
    }

    public String toString() {
        return "Numéro: " + numeroSerie + ", Prix: " + prix;
    }
}
