package vue;

import controleur.IControleur;

public interface IVue {

	void setControleur(IControleur unControleur);

	String getAction();

	double getMontant() throws SaisieInvalideException;

	void demarrer();

	void montrerSolde(double solde);

	void montrerSaisieInvalide();

	void montrerFondInsuffisant();

	void afficherOperation(double montant, String action);

}