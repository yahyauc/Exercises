public class Main {
    public static void main(String[] args) {
        Ingenieur ingenieur = new Ingenieur("Ahmed", "Badr", "ID001", 200);
        Technicien technicien = new Technicien("Sara", "El Mansouri", "ID002", 210);
        SousEmploye sousEmploye = new SousEmploye("Yassine", "Fakir", "ID003", 120);

        System.out.println("Salaire Ingenieur: " + ingenieur.calculerSalaire());
        System.out.println("Cout Total Ingenieur: " + ingenieur.calculerCoutTotal());

        System.out.println("Salaire Technicien: " + technicien.calculerSalaire());
        System.out.println("Cout Total Technicien: " + technicien.calculerCoutTotal());

        System.out.println("Salaire Sous-Employe: " + sousEmploye.calculerSalaire());
        System.out.println("Cout Total Sous-Employe: " + sousEmploye.calculerCoutTotal());
    }
}
