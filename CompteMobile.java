public class CompteMobile {
    private double solde;

    public CompteMobile() {
        this.solde = 0;
    }

    public CompteMobile(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public double getSolde() {
        return solde;
    }

    public void recharger(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Rechargement de " + montant + "DH effectué.");
        } else {
            System.out.println("Montant invalide !");
        }
    }

    public void appeler(int duree, double tarifParMinute) {
        double cout = duree * tarifParMinute;
        if (solde >= cout) {
            solde -= cout;
            System.out.println("Appel de " + duree + " minutes effectué. Coût: " + cout + "DH. Nouveau solde: " + solde + "DH");
        } else {
            System.out.println("Solde insuffisant pour cet appel.");
        }
    }

    public void ajouteBonus(double pourcentage) {
        if (pourcentage > 0) {
            double bonus = solde * (pourcentage / 100);
            solde += bonus;
            System.out.println("Bonus de " + pourcentage + "% ajouté. Nouveau solde: " + solde + "DH");
        } else {
            System.out.println("Pourcentage de bonus invalide !");
        }
    }

    public static void main(String[] args) {
        CompteMobile compte = new CompteMobile(50);
        System.out.println("Solde initial: " + compte.getSolde() + "DH");

        compte.recharger(20);
        compte.appeler(5, 2);
        compte.ajouteBonus(10);

        System.out.println("Solde final: " + compte.getSolde() + "DH");
    }
}

