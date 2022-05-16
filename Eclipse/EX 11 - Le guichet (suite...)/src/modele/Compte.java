package modele;

public class Compte implements ICompte {
	private double solde;

	public Compte(double depotInitial) {
		this.solde = depotInitial;
	}

	@Override
	public void deposer(double montant) {
		this.solde += montant;
	}

	@Override
	public void retirer(double montant) throws FondInsuffisantException {
		if (this.solde < montant) {
			throw new FondInsuffisantException();
		}

		this.solde -= montant;
	}

	@Override
	public double getSolde() {
		return this.solde;
	}
}
