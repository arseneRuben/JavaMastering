class Singleton {
	private static Singleton instance = null;

	private Singleton() {
	}

	static public Singleton getInstance() {
		if (Singleton.instance == null) {
			Singleton.instance = new Singleton();
		}
		return Singleton.instance;
	}
}

public class Principale {

	static int help() {
		System.out.println("dans help de Principale: OMG");
		return 666;
	}

	public static void main(String[] args) {
		System.out.println("dans main: Hello world!");
	}

	public static final int x = Principale.help();
}
