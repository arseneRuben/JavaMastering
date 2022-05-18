import java.util.ArrayList;

import modele.Personne;

@SuppressWarnings("serial")
class MyArrayList<E> extends ArrayList<E> {
	@Override
	public String toString() {
		String res = "[";
		for (E elt : this) {
			res += elt.toString() + ", ";
		}
		res += "]";
		return res;
	}
}

public class Principale {
	public static Personne f(ArrayList<Personne> liste, int id) {
		// traitement
//		for (Personne p : liste) {
//			if (p.getId() == id) {
//				return p;
//			}
//		}
//		return null;

		int i = 0;
		while (i < liste.size() && liste.get(i).getId() != id) {
			i++;
		}
		
		return i < liste.size() ? liste.get(i) : null;
		
//		if (i < liste.size()) {
//			return liste.get(i);
//		}
//		else {
//			return null;
//		}
			
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyArrayList<Personne> liste = new MyArrayList<>();

		liste.add(new Personne(12, "titi"));
		liste.add(new Personne(5, "toto"));
		liste.add(new Personne(7, "tata"));

		System.out.println(liste);
		String s = liste.toString();

		// PAS de polymorphisme
		liste.toString();

		// polymorphisme
		Object l = liste; // upcast Fille -> Mere
		l.toString();
	}
}
