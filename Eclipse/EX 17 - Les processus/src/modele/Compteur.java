package modele;
import java.util.ArrayList;

//	La classe des écoutés
public class Compteur extends Thread {
	private int cpt = 0;
	private ArrayList<IEcouteurCompteur> lesEcouteurs = new ArrayList<>();

	private static void attendre(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			cpt++;
			this.notifierEcouteurs();
			//System.out.println(cpt);
			attendre(1000);
		}
	}
	
	public static void main(String[] toto) {
		Compteur unCompteur = new Compteur();
		unCompteur.start();
		
		Compteur unAutreCompteur = new Compteur();
		unAutreCompteur.start();
	}

	public void notifierEcouteurs() {
		for(IEcouteurCompteur e : this.lesEcouteurs) {
			e.compteurChange(this.cpt);
		}
	}
	
	public void ajouterEcouteur(IEcouteurCompteur unEcouteur) {
		this.lesEcouteurs.add(unEcouteur);
	}
}






