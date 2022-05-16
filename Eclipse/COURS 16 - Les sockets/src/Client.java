import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			//	Tentative de connexion au serveur
			System.out.println("Client : tentative de connexion...");
			Socket cSocket = new Socket("127.0.0.1", 1234);
			System.out.println("Client : connexion etablie!");

			//	Affichage de l'adresse IP
			System.out.println("IP : " + cSocket.getInetAddress());

			// Creation des objets pour la communication
			InputStream is = cSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// lecture des donnees provenant du serveur
			String ligne = br.readLine();

			System.out.println("Client : le serveur a envoye : '" + ligne + "'");
			System.out.println("Client : fermeture de la connexion");

			cSocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
