class Cosmetique extends Produit {
    String dateFabrication;

    public Cosmetique(String numeroSerie, double prix, String dateFabrication) {
        super(numeroSerie, prix);
        this.dateFabrication = dateFabrication;
    }

    public String toString() {
        return super.toString() + ", Fabrication: " + dateFabrication;
    }
}
