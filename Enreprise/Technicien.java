public class Technicien extends EmployeBase implements Employe {

    public Technicien(String nom, String prenom, String identifiant, int heuresTravaillees) {
        super(nom, prenom, identifiant, heuresTravaillees);
    }

    @Override
    public double calculerSalaire() {
        double salaireFixe = (3500 * 12) + 2000;
        int heuresSupp = getHeuresTravaillees() - 200;
        if (heuresSupp > 0) {
            return salaireFixe + (heuresSupp * 100);
        }
        return salaireFixe;
    }

    @Override
    public double calculerCoutTotal() {
        double salaireBrut = calculerSalaire();
        return salaireBrut * 1.15;
    }
}
