package controleur;

import java.util.ArrayList;
import java.util.Hashtable;

import modele.Magasin;
import modele.Panier;
import modele.PlusDeBananeException;
import modele.Produit;
import vue.PanierAchatUI;

public class Controleur {
	private PanierAchatUI laVue;
	private Magasin leMagasin;
	private Panier lePanier;

	public void setLaVue(PanierAchatUI laVue) {
		this.laVue = laVue;
	}

	public void setLeMagasin(Magasin leMagasin) {
		this.leMagasin = leMagasin;
	}

	public void setLePanier(Panier lePanier) {
		this.lePanier = lePanier;
	}

	public void action() {
		try {
			// aupres de la vue :
			// - recuperer le nom du produit
			// - recuperer la quantite demandee
			Produit p = this.laVue.getProduitSelectionne();
			int quantite = this.laVue.getQuantiteDemandee();

			// aupres du magasin :
			// - retirer ce produit du magasin
			Produit produitChoisi = new Produit(p.getId(), p.getDesignation(), quantite);
			this.leMagasin.retirerProduit(produitChoisi);
			// aupres du panier :
			// - ajouter ce produit au panier
			// - demander la liste des produits du panier
			this.lePanier.ajouterProduit(produitChoisi);
			Hashtable<Integer, Produit> liste = this.lePanier.getListeProduits();

			// aupres de la vue :
			// - afficher la liste des produits du panier
			this.laVue.montrerPanier(liste);
		} catch (PlusDeBananeException e) {
		}
	}

	public Hashtable<Integer, Produit> getProduitsMagasin() {
		return leMagasin.getListeProduits();
	}

}
