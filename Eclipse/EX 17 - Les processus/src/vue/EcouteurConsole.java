package vue;

import modele.IEcouteurCompteur;

public class EcouteurConsole implements IEcouteurCompteur {
	@Override
	public void compteurChange(int valeur) {
		System.out.println("Le compteur a change : " + valeur);
	}
}
