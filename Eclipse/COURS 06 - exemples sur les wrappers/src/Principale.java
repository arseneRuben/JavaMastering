//	on peut creer son propre wrapper
//	avantage : la donnee n'est pas necessairement 'final'
//	inconveniants : on ne beneficie pas du boxing/unboxing
class MyInteger {
	private int value; // donnee encapsulee

	// constructeur
	public MyInteger(int value) {
		this.value = value;
	}

	// mutateur
	public void setValue(int value) {
		this.value = value;
	}

	// accesseur
	public int getValue() {
		return this.value;
	}

	// redefinition de la methode toString heritee de Object
	// pour pouvoir effectuer du polymorphisme
	@Override
	public String toString() {
		return "" + this.value;
	}

}

public class Principale {
	//	on peut donner n'importe quoi a cette methode
	//	- si c'est une instance de classe, il sera 'casté' en Object (upcast)
	//	- si c'est une information de type primitif, il sera encapsulé dans son wrapper correspondant
	public static void f(Object o) {
		if (o instanceof Integer) {
			System.out.println("C'est un Integer!");
		}
		System.out.println(o);
	}

	public static void inc(Integer i) {
		i++;	
		//	ici, i contient l'adresse d'un AUTRE Integer...
	}

	public static void inc(MyInteger i) {
		i.setValue(i.getValue() + 1);
		//	ici, i contient la meme adresse.
		//	la zone pointee encapsule un entier incremente de 1
	}

	public static void main(String[] args) {
		f(56);
		// compile en :
		f(Integer.valueOf(56));

		Integer i = 13;
		System.out.println("i = " + i);
		i++;
		// OU
		i = (i /* unboxing */ + 1) /* boxing */;
		// OU
		i = Integer.valueOf(i.intValue() + 1);
		System.out.println("i = " + i);

		// methode inc qui prend une instance de Integer
		System.out.println("avant inc, i = " + i);
		Principale.inc(i);
		System.out.println("apres inc, i = " + i); // valeur identique

		MyInteger mi = new MyInteger(13);
		System.out.println(mi);

		//	methode inc qui prend une instance de MyInteger
		System.out.println("avant inc, mi = " + mi);
		Principale.inc(mi);
		System.out.println("apres inc, mi = " + mi); // valeur incrementee
	}
}
