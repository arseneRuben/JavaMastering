import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ConnexionAuServeur {
	Socket socket;
	String adresseIP;
	BufferedReader lecteur;
	PrintWriter ecrivain;

	public ConnexionAuServeur(String ip, int port) throws IOException {
		try {
			System.out.println("CLIENT - connection au serveur en cours...");
			this.socket = new Socket(ip, port);
			this.lecteur = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.ecrivain = new PrintWriter(this.socket.getOutputStream(), true);
			System.out.println("CLIENT - connection établie");
		} catch (UnknownHostException e) {
			throw new UnknownHostException("serveur non valide...");
		} catch (IOException e) {
			throw new IOException("connexion au serveur impossible...");
		}
	}

	public int lireNombre() throws IOException {
		try {
			int nb = Integer.valueOf(lecteur.readLine());
			System.out.println("CLIENT - " + nb);
			return nb;
		} catch (NumberFormatException e) {
			throw new NumberFormatException("mauvais format de nombre...");
		} catch (IOException e) {
			throw new IOException("erreur reseau durant la lecture du nombre...");
		}
	}

	public void envoyerNombre(int n) {
		System.out.println("CLIENT - envoie du nombre " + n + " au serveur.");
		ecrivain.println(n);
	}

	public void fermer() throws IOException {
		try {
			socket.close();
		} catch (IOException e) {
			throw new IOException("erreur durant la fermeture de la connexion...");
		}
	}
}

public class Client extends Thread {
	private static final int PORT = 4321;

	ConnexionAuServeur connexion;

	public void run() {
		try {
			connexion = new ConnexionAuServeur("127.0.0.1", PORT);
			int somme = connexion.lireNombre() + connexion.lireNombre();
			connexion.envoyerNombre(somme);
			connexion.fermer();
		} catch (Exception e) {
			System.out.println("CLIENT - " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Client().start();
	}
}
