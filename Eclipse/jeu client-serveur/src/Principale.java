import java.io.IOException;

public class Principale {

	public static void main(String[] args) throws IOException {
		System.out.println("MAIN : start");
		new Serveur().start();
		new Client().start();
		System.out.println("MAIN : end");
	}
}
