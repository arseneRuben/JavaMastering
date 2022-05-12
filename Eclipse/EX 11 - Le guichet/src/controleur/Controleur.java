package controleur;

import modele.Compte;
import vue.GuichetUI;

public class Controleur {
	GuichetUI laVue;
	Compte leCompte;

	public Controleur(GuichetUI laVue, Compte leCompte) {
		this.laVue = laVue;
		this.leCompte = leCompte;
	}

	public void action() {
		// 1- demander quelle est l'action demandee par l'utilisateur de l'applciation
		String action = laVue.getAction();

		// 2- si c'est quitter, alors quitter
		// 3- sinon, demander le montant de l'operation
		// 4- enchainer toutes les actions spour cette operation

		laVue.getAction();

	}
}
