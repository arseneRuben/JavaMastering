import controleur.Controleur;
import modele.Magasin;
import modele.Panier;
import modele.Produit;
import vue.PanierAchatUI;

public class Principale {
	public static void main(String[] args) {
		//	creation des objets du modele
		PanierAchatUI vue = new PanierAchatUI("Bananes du Monde");
		Controleur leControleur = new Controleur();
		
		Magasin leMagasin = new Magasin();
		leMagasin.ajouterProduit(new Produit(1, "Banane de Chine", 20));
		leMagasin.ajouterProduit(new Produit(2, "Banane du Japon", 12));
		leMagasin.ajouterProduit(new Produit(3, "Cuban Banana", 15));
		leMagasin.ajouterProduit(new Produit(4, "Les Bananes de France", 10));
		
		Panier lePanier = new Panier();
		
		//	mise en relation
		leControleur.setLaVue(vue);
		leControleur.setLeMagasin(leMagasin);
		leControleur.setLePanier(lePanier);
		
		vue.setControleur(leControleur);
	}
}






