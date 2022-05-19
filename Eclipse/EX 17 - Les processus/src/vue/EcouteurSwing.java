package vue;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import modele.IEcouteurCompteur;

public class EcouteurSwing extends JFrame implements IEcouteurCompteur {
	private final static Font laFonte = new Font("Consolas", Font.BOLD, 64);
	private JLabel lbl_compteur = new JLabel();
	
	public EcouteurSwing(String titre) throws Exception {
		super(titre);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(200, 200);
		this.setLocation(1920 + 200,  200);
		
		if (EcouteurSwing.laFonte == null) {
			throw new Exception("Fonte pas correcte!!!");
		}
		this.lbl_compteur.setFont(EcouteurSwing.laFonte);
		this.add(this.lbl_compteur);
		
		this.setVisible(true);
	}

	@Override
	public void compteurChange(int valeur) {
		this.lbl_compteur.setText("" + valeur);		
	}
}
