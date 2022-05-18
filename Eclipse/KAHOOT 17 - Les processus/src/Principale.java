class MonProcessus extends Thread {
	public static Object stylo = new Object();
	public static int cpt = 0; // ressource à synchroniser

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (MonProcessus.stylo) {
				MonProcessus.cpt++;
				System.out.println("Processus : " + MonProcessus.cpt);
			}

			Principale.attendre(400);
		}
		System.out.println("Fin de run().");
	}
}

public class Principale {
	public static void attendre(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MonProcessus mp = new MonProcessus();
		mp.start();

		Principale.attendre(200);
		for (int i = 0; i < 10; i++) {
			synchronized (MonProcessus.stylo) {
				MonProcessus.cpt++;
				System.out.println("Main : " + MonProcessus.cpt);
			}
			Principale.attendre(200);
		}
		System.out.println("Fin de main().");
	}
}
