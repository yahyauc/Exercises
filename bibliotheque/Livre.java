// Livre.java
public class Livre {
    private int id_livre;
    private String titre;
    private String auteur;
    private int aneee_publication;

    public Livre(int id_livre, String titre, String auteur, int aneee_publication) {
        this.id_livre = id_livre;
        this.titre = titre;
        this.auteur = auteur;
        this.aneee_publication = aneee_publication;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAneee_publication() {
        return aneee_publication;
    }

    public void setAneee_publication(int aneee_publication) {
        this.aneee_publication = aneee_publication;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id_livre=" + id_livre +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", aneee_publication=" + aneee_publication +
                '}';
    }
}
