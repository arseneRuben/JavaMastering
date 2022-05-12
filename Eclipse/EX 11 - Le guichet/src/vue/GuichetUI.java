package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//class EcouteurBouton implements ActionListener {
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	}
//}

@SuppressWarnings("serial")
public class GuichetUI extends JFrame implements ActionListener {
	private static final String[] nomsBoutons = { "Depot", "Retrait", "Exit" };
	private static final String[] actionBouton = { "deposer", "retirer", "quitter" };

	private JTextField txtfld_montant;
	private JLabel lbl_resume;

	private String action;

	public GuichetUI(String titre) {
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(1920 + 100, 200);
		this.setSize(400, 400);

		this.setLayout(new GridLayout(0, 1));
		this.add(new JLabel("Solde"));
		this.add(new JLabel("0.0"));
		this.txtfld_montant = new JTextField(30);
		this.add(txtfld_montant);

		for (int i = 0; i < GuichetUI.nomsBoutons.length; i++) {
			JButton btn = new JButton(GuichetUI.nomsBoutons[i]);
			btn.setActionCommand(actionBouton[i]);
			btn.addActionListener(this);
			this.add(btn);
		}

		lbl_resume = new JLabel("Aucune transaction effectuee");
		this.add(lbl_resume);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GuichetUI("D.A.B.");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JButton leBouton = (JButton) source;
		String texteAction = leBouton.getText();
		System.out.println(texteAction);
		this.action = leBouton.getActionCommand();

		if (leBouton.getActionCommand() == "quitter") {
			System.exit(0);
		}

		String texte = this.txtfld_montant.getText();
		this.txtfld_montant.setText("");
		boolean montantValide = true;
		double montant = 0;

		try {
			montant = Double.valueOf(texte);
		} catch (NumberFormatException ex) {
			this.lbl_resume.setText("Montant saisi invalide!");
			montantValide = false;
		}

		if (montantValide) {
			System.out.println("Montant : " + montant);
		}
	}

	public String getAction() {
		return this.action;
	}
}
