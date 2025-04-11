class Alimentaire extends Produit {
    String datePeremption;

    public Alimentaire(String numeroSerie, double prix, String datePeremption) {
        super(numeroSerie, prix);
        this.datePeremption = datePeremption;
    }

    public String toString() {
        return super.toString() + ", Péremption: " + datePeremption;
    }
}
