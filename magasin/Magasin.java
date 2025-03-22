import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Magasin{
    ArrayList<Produit> produits = new ArrayList<Produit>();
    HashMap<String, Integer> stock = new HashMap <>();
    ArrayList<Employe> employes = new ArrayList<Employe>();

    public void AjouterProduit(Produit p, int quantite){
        produits.add(p);
        stock.put(p.getcode(), quantite);
    }

    public void supprimerproduit(String code){
        for(int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getcode().equals(code)) {
                produits.remove(i);
                break;
            }
        }
    }
    public void afficherProduit(){
        for(Produit p :produits){
            System.out.println(p + "qtit:" + stock.get(p.getcode()));
        }
    }

    public void chercherparcategorie(String categorie){
        for(Produit p : produits){
            if ( p.getcategorie().equalsIgnoreCase(categorie)){
                System.out.println(p + "qtt:" + stock.get(p.getcode()));
            }
        }
    }

    public void ajouteremploye(Employe e){
        emplyes.add(e);
    }
    public void afficheremploye(){
            for (Employe e : emplyes) {
                System.out.println(e);
            }

    }

    public void supemploye(String poste){
        for(int i = 0; i <  emplyes.size(); i++) {
            if (emplyes.get(i).getPoste().equals(poste)) {
                emplyes.remove(i);
                break;
            }
        }
    }
    // lfikra mn9ola mn rechercheparcode hhhhh
    public void chercherparposte(String poste){
        for(Employe E : emplyes){
            if ( E.getPoste().equalsIgnoreCase(poste)){
                System.out.println(E + "qtt:" + stock.get(E.getPoste()));
            }
        }
    }
}
