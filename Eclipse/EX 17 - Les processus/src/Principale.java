import modele.*;
import vue.EcouteurConsole;
import vue.EcouteurSwing;

public class Principale {

	public static void main(String[] args) throws Exception {
		// Creation du compteur (c'est l'écouté)
		Compteur leCompteur = new Compteur();

		// creation d'un écouteur
		IEcouteurCompteur unEcouteur = new EcouteurConsole();
		// enregistrement de l'écouteur auprès du compteur
		leCompteur.ajouterEcouteur(unEcouteur);

		for (int i = 0; i < 20; i++) {
			// Creation d'un autre écouteur
			IEcouteurCompteur unAutreEcouteur = new EcouteurSwing("Ecouteur de compteur");
			// enregistrement de l'écouteur auprès du compteur
			leCompteur.ajouterEcouteur(unAutreEcouteur);
		}

		leCompteur.start();
	}
}
