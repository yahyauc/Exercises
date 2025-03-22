public class Produit {
    String code;
    String nom;
    String categorie;
    double prix;



    public Produit(String code, String nom, String categorie, double prix){
        this.code = code;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
    }



    public String getcode(){
        return code;
    }

    public void setcodeString(String code){
        this.code = code;
    }
    public String getnom(){
        return nom;
    }

    public void setnom(String nom){
        this.nom = nom;
    }
    public String getcategorie(){
        return categorie;
    }

    public void setcategorie(String categorie){
        this.categorie = categorie;
    }

    public double getprix(){
        return prix;
    }

    public void setprix(double prix){
        this.prix = prix;
    }


}
