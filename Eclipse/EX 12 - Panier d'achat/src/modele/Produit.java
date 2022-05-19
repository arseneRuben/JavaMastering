package modele;

public class Produit {
	final private int id;
	final private String designation;
	private int quantite;
	
	public Produit(int id, String designation, int quantite) {
		this.id = id;
		this.designation = designation;
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		return "" + this.designation + "(" + this.quantite + ")";
	}
}











