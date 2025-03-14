public class SousEmploye extends EmployeBase implements Employe {

    public SousEmploye(String nom, String prenom, String identifiant, int heuresTravaillees) {
        super(nom, prenom, identifiant, heuresTravaillees);
    }

    @Override
    public double calculerSalaire() {
        return getHeuresTravaillees() * 150;
    }

    @Override
    public double calculerCoutTotal() {
        double salaireBrut = calculerSalaire();
        return salaireBrut * 1.15;
    }
}
