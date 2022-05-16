import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Hashtable;

class TooManyConnexions extends Exception {
	private static final long serialVersionUID = 1L;

	public TooManyConnexions(String msg) {
		super(msg);
	}
}

class TimeOutException extends Exception {
	private static final long serialVersionUID = 1L;

	public TimeOutException(String msg) {
		super(msg);
	}
}

class ListeConnexions {
	static public int DELAI = 5; // délai minimal entre 2 connexions
	Hashtable<String, Date> lesConnexions;

	private static int calculerEcartEnSecondes(Date date1, Date date2) {
		return (int) ((date2.getTime() - date1.getTime()) / 1000);
	}

	public ListeConnexions() {
		lesConnexions = new Hashtable<String, Date>();
	}

	public void ajouterConnexion(String ip) throws TooManyConnexions {
		Date date = lesConnexions.get(ip);

		if (date == null) {
			System.out.println("nouvelle connexion : " + ip);
		} else if (calculerEcartEnSecondes(date, new Date()) < DELAI)
			throw new TooManyConnexions("veuillez attendre " + ListeConnexions.DELAI + "s entre chaque connexion!");

		lesConnexions.put(ip, new Date());
	}
}

class connexionAuClient {
	private static final int PREMIER_DELAI_ATTENTE = 500;
	private static final int DERNIER_DELAI_ATTENTE = 2000;

	Socket socket;
	String adresseIP;
	BufferedReader lecteur;
	PrintWriter ecrivain;

	public connexionAuClient(Socket socket) throws IOException {
		this.socket = socket;
		this.adresseIP = socket.getInetAddress().getHostAddress();
		this.lecteur = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.ecrivain = new PrintWriter(this.socket.getOutputStream(), true);
	}

	public static int genererNombreAleatoire(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	public int envoyerNombreAleatoire() throws IOException {
		int nb = genererNombreAleatoire(0, 999);
		ecrivain.println(nb);
		return nb;
	}

	public boolean reponsePrete() throws IOException, InterruptedException {
		Thread.sleep(PREMIER_DELAI_ATTENTE);
		if (!lecteur.ready()) {
			System.out.println("    J'attends le client " + adresseIP + "...");
			Thread.sleep(DERNIER_DELAI_ATTENTE);
		}

		return lecteur.ready();
	}

	public int recupererReponse() throws InterruptedException, TimeOutException, IOException {
		try {
			if (reponsePrete()) {
				return Integer.valueOf(lecteur.readLine());
			} else {
				throw new TimeOutException("trop lent...");
			}
		} catch (IOException e) {
			throw new IOException("impossible de lire la ligne...");
		} catch (InterruptedException e) {
			throw new InterruptedException("processus interrompu...");
		} catch (NumberFormatException e) {
			throw new NumberFormatException("ce n'est pas un entier...");
		}
	}
}

public class Serveur extends Thread {
	private static final int NO_PORT = 4321;

	private ServerSocket serverSocket;
	private ListeConnexions listeConnexions;
	private connexionAuClient connexionActuelle;

	public Serveur() throws IOException {
		serverSocket = new ServerSocket(NO_PORT);
		listeConnexions = new ListeConnexions();
		connexionActuelle = null;
	}

	public void afficherMessage(String message) {
		System.out.println("    " + connexionActuelle.adresseIP + " : " + message);
	}

	// --------------------------------------------------------------
	public int evoyerDeuxNombres() throws IOException {
		int nb1 = connexionActuelle.envoyerNombreAleatoire();
		int nb2 = connexionActuelle.envoyerNombreAleatoire();

		System.out.println(
				"    J'envoie les nombres " + nb1 + " et " + nb2 + " au client " + connexionActuelle.adresseIP + "...");

		return nb1 + nb2;
	}

	public void traiterReponseClient(int sommeAdeviner) throws IOException, InterruptedException {
		try {
			if (connexionActuelle.recupererReponse() == sommeAdeviner) {
				afficherMessage("BRAVO !!!");
			} else {
				afficherMessage("mauvaise réponse...");
			}
		} catch (Exception e) {
			afficherMessage(e.getMessage());
		}
	}

	// --------------------------------------------------------------
	private void attendreConnexionClient() throws IOException, TooManyConnexions {
		System.out.println("SERVEUR : attente d'une connection...");
		connexionActuelle = new connexionAuClient(serverSocket.accept());
		System.out.println("    client " + connexionActuelle.adresseIP + " connecté.");
		listeConnexions.ajouterConnexion(connexionActuelle.adresseIP);
	}

	public void jouerAvecClient() throws IOException, InterruptedException {
		int somme = evoyerDeuxNombres();
		traiterReponseClient(somme);
	}

	public void fermerConnexionClient() throws IOException {
		connexionActuelle.socket.close();
		connexionActuelle = null;
	}

	// --------------------------------------------------------------
	public void gererClient() {
		try {
			attendreConnexionClient();
			jouerAvecClient();
			fermerConnexionClient();
		} catch (Exception e) {
			afficherMessage(e.getMessage());
		}
	}

	// --------------------------------------------------------------
	public void run() {
		while (true) {
			gererClient();
		}
	}

	// --------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		new Serveur().start();
	}
}
