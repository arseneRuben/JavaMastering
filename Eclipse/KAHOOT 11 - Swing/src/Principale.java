import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JWindow;

class EcouteurBouton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("COUCOU!!!");
	}
}

public class Principale {
	public static void attendre(int milli) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JWindow w = new JWindow();
		w.setSize(200, 200);
		w.setLocation(1920, 0);
		w.setVisible(true);

		JFrame f = new JFrame("Ma belle fenetre");
		f.setLocation(1920 + 300, 0);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		System.out.println(f.getLayout());

//		f.add(new JButton("Bouton 1"), BorderLayout.CENTER);
//		f.add(new JButton("Bouton 2"), BorderLayout.EAST);
//		f.add(new JButton("Bouton 3"), BorderLayout.NORTH);
//		f.setVisible(true);

//		f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(5, 10));
//		for (int i = 0; i < 50; i++) {
//			f.add(new JButton("btn " + (i + 1)));
//			f.setVisible(true);
//			attendre(500);
//		}
		
		//	ajout d'un ecouteur sur le bouton
		JButton monBouton = new JButton("Bouton 1"); 
		f.add(monBouton, BorderLayout.CENTER);
		monBouton.addActionListener(new EcouteurBouton());
		f.setVisible(true);

		
		
		int cpt = 0;
		while (true) {
			System.out.println(cpt);
			cpt++;
			attendre(1000);

			// f.setVisible(true);

		}

//		System.out.println("Fin du main");

	}

}
