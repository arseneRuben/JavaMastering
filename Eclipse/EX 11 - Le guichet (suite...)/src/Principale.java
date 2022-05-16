import controleur.Controleur;
import controleur.IControleur;
import modele.Compte;
import modele.ICompte;
import vue.GuichetUI;
import vue.IVue;

public class Principale {
	public static void main(String[] args) {
		//	creation des 3 instances de chaque couche
		ICompte leCompte = new Compte(100);
		IControleur leControleur = new Controleur();
		IVue leGuichet = new GuichetUI("Guichet automatique");
		
		//	creation des liens entre ces instances
		leControleur.setVue(leGuichet);
		leGuichet.setControleur(leControleur);
		leControleur.setCompte(leCompte);
		
		//	demarrage de l'application
		leGuichet.demarrer();
	}
}