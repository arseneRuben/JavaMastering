import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static void main(String[] args) {
		try {
			// Creation du ServerSocket pour attendre une connexion
			ServerSocket sSrvSocket = new ServerSocket(1234);

			// Attente d'une connexion d'un client
			System.out.println("Serveur : attente connexion client");
			Socket sSocket = sSrvSocket.accept();
			System.out.println("Serveur : connexion etablie!");

			//	affichage de l'adresse IP
			System.out.println("IP : " + sSocket.getInetAddress());
			
			// Preparation du flux de sortie
			OutputStream os = sSocket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			// Envoi des donnees au client
			System.out.println("Serveur : aEnvoi des donnees");
			bw.write("Hello!\n");
			bw.flush();

			System.out.println("Serveur : aFermeture de la connexion");
			sSocket.close();
			sSrvSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
