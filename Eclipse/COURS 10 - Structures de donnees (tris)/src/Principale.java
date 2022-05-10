import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum Critere {
	DESIGNATION, POIDS, PRIX;
}

class Produit implements Comparable<Produit> {
	String designation;
	double prix;
	double poids;

	public Produit(String designation, double prix, double poids) {
		this.designation = designation;
		this.prix = prix;
		this.poids = poids;

	}

	@Override
	public int compareTo(Produit autreProduit) {
		return this.designation.compareTo(autreProduit.designation);
	}

	@Override
	public String toString() {
		return designation + "(" + prix + "$, " + poids + "g)";
	}
}

class ComparateurDesignation implements Comparator<Produit> {
	@Override
	public int compare(Produit prod1, Produit prod2) {
		return prod1.designation.compareTo(prod2.designation);
	}
}

class Stock {
	ArrayList<Produit> liste = new ArrayList<Produit>();

	public void trier() {
		Collections.sort(this.liste);
	}

	public void trier(Critere critere) {
		switch (critere) {
		case DESIGNATION:
			Collections.sort(this.liste, new ComparateurDesignation());
			break;
		case POIDS:
			break;
		case PRIX:
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Stock [liste=" + liste + "]";
	}
}

public class Principale {

	public static void main(String[] args) {
//		ArrayList<String> liste = new ArrayList<String>();
//
//		liste.add("toto");
//		liste.add("abracadabra");
//		liste.add("zoro");
//		liste.add("tarentule");
//
//		System.out.println(liste);
//		Collections.sort(liste);
//		System.out.println(liste);

		Stock monStock = new Stock();
		monStock.liste.add(new Produit("Pomme", 12, 5));
		monStock.liste.add(new Produit("Poire", 4, 1));
		monStock.liste.add(new Produit("Banane", 18, 14));

		System.out.println(monStock);
		//monStock.trier();
		monStock.trier(Critere.DESIGNATION);
		System.out.println(monStock);
	}
}
