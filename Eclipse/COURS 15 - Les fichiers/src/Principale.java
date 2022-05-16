import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principale {

	public static void lecture(String nom) {
		try {
			// ouverture du fichier en lecture
			FileReader fr = new FileReader(nom);
			BufferedReader br = new BufferedReader(fr);
			
			// lecture et affichages des lignes du fichier
			boolean fini = false;
			while (!fini) {
				String ligne = br.readLine();
				if (ligne != null) {
					System.out.println(ligne);
				}
				else {
					fini = true;
				}
			}

			// fermeture du fichier
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1); // quitter l'application
		}

	}

	public static void ecriture(String nom) {
		//	ouverture du fichier en ecriture
		try {
			FileWriter fw = new FileWriter(nom, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			bw.write("Hello world!\n");
				
			//	fermeture du fichier
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//Principale.lecture("src/Principale.java");
		Principale.ecriture("src/toto.txt");
		
		String str;
		
	}
}









