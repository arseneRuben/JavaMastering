class MonType<T> {
	int n;

	public void print(T objet) {
		System.out.println(objet);
		// T a = new T(); // ne compile pas car T n'est pas connu a la compilation
	}
}

class GroupeAnimaux<A extends Animal> {
	private static final int MAX_SIZE = 5;

	private Animal[] lesAnimaux;
	private int nbAnimaux;

	public GroupeAnimaux() {
		this.nbAnimaux = 0;
		this.lesAnimaux = new Animal[GroupeAnimaux.MAX_SIZE];
	}

	public void ajouter(A unAnimal) {
		this.lesAnimaux[this.nbAnimaux] = unAnimal;
		this.nbAnimaux++;
	}

	@SuppressWarnings("unchecked")
	public A get(int i) {
		return (A) this.lesAnimaux[i];
	}
}

class Animal {
}

class Renard extends Animal {
}

class Poule extends Animal {
}

public class Principale {

	public static void print(int n) {
		System.out.println(n);
	}

	public static void test1() {
		Principale.print(45);

		MonType<Integer> n1 = new MonType<Integer>();
		n1.print(45);
		MonType<Double> n2 = new MonType<>();
		n2.print(45.0);
		MonType<Principale> n3 = new MonType<>();
		n3.print(new Principale());
	}

	public static void test2() {
		GroupeAnimaux<Animal> groupe = new GroupeAnimaux<>();
		groupe.ajouter(new Renard());
		groupe.ajouter(new Renard());
		groupe.ajouter(new Poule());
	}

	public static void main(String[] args) {
		// Principale.test1();
		Principale.test2();
	}
}

