//import java.lang.String; // non necessaire

public class Principale {

	public static void initTableau(int[] benoit) {
		// on met des valeurs dans les cases
		for (int i = 0; i < benoit.length; i++) {
			benoit[i] = 2 * i + 7;
		}
	}

	public static void afficherTab(int[] alain) {
		for (int v : alain) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// declaration et initialisation
		int[] tab = new int[10];

		// on met des valeurs dans les cases
		/*
		 * for (int i = 0; i < tab.length; i++) { tab[i] = 2 * i + 7; }
		 */
		Principale.initTableau(tab);

		// affichage des entiers du tableau
		// avec une boucle for 'conventionnelle'
		for (int i = 0; i < tab.length; i++) {
			String str = String.valueOf(tab[i]);
			System.out.print(str + " ");
			// OU
			// System.out.println(tab[i] + " ");
		}
		System.out.println();
		Principale.afficherTab(tab);

		// affichage des entiers du tableau
		// avec une boucle for 'conventionnelle'
		for (int v : tab) {
			v *= 2;
		}

		for (int v : tab) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

}
