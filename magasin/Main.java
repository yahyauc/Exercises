public class Main {
    public static void main(String[] args) {

        

        Magasin magasin = new Magasin();


        Produit p1 = new Produit("01332323", "radio", "lmohim", 20 );
        Produit p2 = new Produit("12888282", "makina", "lmohim", 300);
        magasin.AjouterProduit(p1, 10);
        magasin.AjouterProduit(p2, 5);


        System.out.println(" Liste des produits :");
        magasin.afficherProduit();


        System.out.println("\n Produits dans la categorie  :");
        magasin.chercherparcategorie("testing");


        magasin.supprimerproduit("12888282");
        System.out.println("\n Liste des produits après suppression :");
        magasin.afficherProduit();


        Employe e1 = new Employe("111", "Ahmed", "ali", "ingenieur", 10000);
        Employe e2 = new Employe("011", "Omar", "woll", "comtable ", 7000.0);
        magasin.ajouteremploye(e1);
        magasin.ajouteremploye(e2);


        System.out.println("\n Liste des employes :");
        magasin.afficheremploye();


        System.out.println("\n Employes shearch b poste  :");
        magasin.chercherparposte("tst");


        magasin.supemploye("comptable");
        System.out.println("\n Liste des employes mor suppression :");
        magasin.afficheremploye();
    }
}
