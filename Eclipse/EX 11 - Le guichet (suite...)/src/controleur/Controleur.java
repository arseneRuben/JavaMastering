package controleur;

import modele.FondInsuffisantException;
import modele.ICompte;
import vue.IVue;
import vue.SaisieInvalideException;

public class Controleur implements IControleur {
	IVue laVue;
	ICompte leCompte;

	@Override
	public void setVue(IVue uneVue) {
		this.laVue = uneVue;
	}

	@Override
	public void setCompte(ICompte unCompte) {
		this.leCompte = unCompte;
	}

	@Override
	public double getSolde() {
		return this.leCompte.getSolde();
	}

	@Override
	public void action() {
		// 1- demander quelle est l'action demandee par l'utilisateur de l'applciation
		String action = laVue.getAction();

		// 2- si c'est quitter, alors quitter
		if (action == "quitter") {
			System.exit(0);
		}

		// 3- sinon, demander le montant de l'operation
		double montant = 0;
		try {
			montant = this.laVue.getMontant();

			// 4- enchainer toutes les actions pour cette operation
			if (action == "deposer") {
				this.leCompte.deposer(montant);
			} else {
				this.leCompte.retirer(montant);
			}
			double solde = this.leCompte.getSolde();
			this.laVue.montrerSolde(solde);

			this.laVue.afficherOperation(montant, action);

		} catch (FondInsuffisantException e) {
			this.laVue.montrerFondInsuffisant();
		} catch (SaisieInvalideException e) {
			// montant saisi incorrect
			this.laVue.montrerSaisieInvalide();
		} 
	}
}
