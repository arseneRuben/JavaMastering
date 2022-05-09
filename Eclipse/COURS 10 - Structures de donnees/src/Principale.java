import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map.Entry;

public class Principale {
	public static void afficher(ArrayList<Integer> al) {
		System.out.println("Liste de " + al.size() + " elements.");
		for (Integer v : al) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	public static void testArrayList() {
		ArrayList<Integer> al = new ArrayList<>();
		Principale.afficher(al);

		al.add(45);
		Principale.afficher(al);

		al.set(0, 89);
		al.add(0, 90);
		Principale.afficher(al);

		al.add(12);
		al.add(51);
		al.add(1);
		al.add(235);
		Collections.sort(al);

		Principale.afficher(al);
	}

	public static void testHashTable() {
		Hashtable<Integer, String> ht = new Hashtable<>();
		ht.put(45, "quarante cinq");
		ht.put(12, "douze");
		ht.put(11, "onze");

		for (var e : ht.entrySet()) {
			System.out.println("(" + e.getKey() + ", " + e.getValue() + ")");
		}
		// OU
		for (Entry<Integer, String> e : ht.entrySet()) {
			System.out.println("(" + e.getKey() + ", " + e.getValue() + ")");
		}
	}

	public static void main(String[] args) {
		Principale.testArrayList();
		/*
		 * Principale.testHashTable();
		 * 
		 * Principale p = new Principale(); System.out.println(p);
		 * System.out.println(p.hashCode());
		 */

		System.out.println(456);

	}
}
