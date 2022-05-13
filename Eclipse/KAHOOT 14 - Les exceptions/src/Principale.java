
public class Principale {
	static int get(int[] tab, int indice) throws Exception {
		int res = -232364756;
		try {
			res = tab[indice];
		} catch (Exception e) {
			throw new Exception("COUCOU!");
		}
		System.out.println("Dans get...");
		return res;
	}

	public static void main(String[] args) throws Exception {
//		int[] t = new int[10];
//
//		System.out.println("valeur = " + Principale.get(t, 3));
//		System.out.println("valeur = " + Principale.get(t, 30));
		
		//int n = 1 / 0;	//	 java.lang.ArithmeticException: / by zero
		double x = 0.0 / 0;
		//double x = -Math.asin(120);
		
		System.out.println(Double.MAX_VALUE);
		System.out.println("x = " + x);
		System.out.println("Fin du main");
		
	}
}
