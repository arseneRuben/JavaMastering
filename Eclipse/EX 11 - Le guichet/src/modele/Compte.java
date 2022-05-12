package modele;

public class Compte {
	private double solde;

	public void deposer(double montant) {
		this.solde += montant;
	}

	public void retirer(double montant) {
		this.solde -= montant;
	}
	
	public double getSolde() {
		return this.solde;
	}
}
