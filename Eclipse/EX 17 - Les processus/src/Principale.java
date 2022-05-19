import modele.*;
import vue.EcouteurConsole;
import vue.EcouteurSwing;

public class Principale {

	public static void main(String[] args) throws Exception {
		// Creation du compteur (c'est l'�cout�)
		Compteur leCompteur = new Compteur();

		for (int i = 0; i < 5; i++) {
			// Creation d'un autre �couteur
			IEcouteurCompteur unAutreEcouteur = new EcouteurSwing("Ecouteur de compteur");
			// enregistrement de l'�couteur aupr�s du compteur
			leCompteur.ajouterEcouteur(unAutreEcouteur);
		}

		leCompteur.start();
	}
}
