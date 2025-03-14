public class Ingenieur extends EmployeBase implements Employe {

    public Ingenieur(String nom, String prenom, String identifiant, int heuresTravaillees) {
        super(nom, prenom, identifiant, heuresTravaillees);
    }

    @Override
    public double calculerSalaire() {
        double salaireFixe = 9000 * 12;
        int heuresSupp = getHeuresTravaillees() - 180;
        if (heuresSupp > 0) {
            return salaireFixe + (heuresSupp * 200);
        }
        return salaireFixe;
    }

    @Override
    public double calculerCoutTotal() {
        double salaireBrut = calculerSalaire();
        return salaireBrut * 1.15;
    }
}
