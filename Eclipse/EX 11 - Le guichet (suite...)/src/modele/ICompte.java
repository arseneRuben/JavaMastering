package modele;

public interface ICompte {
	void deposer(double montant);
	void retirer(double montant) throws FondInsuffisantException;
	double getSolde();
}