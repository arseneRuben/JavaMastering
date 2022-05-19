package modele;

import java.util.Hashtable;

public class Magasin {
	private Hashtable<Integer, Produit> stock;
	
	public Magasin() {
		this.stock = new Hashtable<Integer, Produit>();
	}
	
	public void ajouterProduit(Produit p) {
		if (this.stock.containsKey(p.getId())) {
			Produit produit = this.stock.get(p.getId());
			produit.setQuantite(produit.getQuantite() + p.getQuantite());
		}
		else {
			this.stock.put(p.getId(), p);			
		}
	}
	
	public void retirerProduit(Produit p) throws PlusDeBananeException {
		if (this.stock.containsKey(p.getId())) {
			Produit produit = this.stock.get(p.getId());
			
			if (p.getQuantite() > produit.getQuantite()) {
				/// TODO:  creer une exception plus specifique
				throw new PlusDeBananeException();
			}
			produit.setQuantite(produit.getQuantite() - p.getQuantite());			
		}
		else {
			/// TODO:  creer une exception plus specifique
			throw new PlusDeBananeException();	
		}
	}

	public Hashtable<Integer, Produit> getListeProduits() {
		return this.stock;
	}
}
