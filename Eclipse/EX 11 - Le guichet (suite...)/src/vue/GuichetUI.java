package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controleur.IControleur;

@SuppressWarnings("serial")
public class GuichetUI extends JFrame implements ActionListener, IVue {
	private static final String[] nomsBoutons = { "Depot", "Retrait", "Exit" };
	private static final String[] actionBouton = { "deposer", "retirer", "quitter" };

	private JLabel lbl_solde;
	private JTextField txtfld_montant;
	private JLabel lbl_resume;

	private String action;

	private IControleur leControleur;

	public GuichetUI(String titre) {
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(1920 + 100, 200);
		this.setSize(400, 400);

		this.setLayout(new GridLayout(0, 1));
		this.add(new JLabel("Solde"));

		this.lbl_solde = new JLabel("Hello world!");
		this.add(this.lbl_solde);

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

	}

	public static void main(String[] args) {
		new GuichetUI("D.A.B.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JButton leBouton = (JButton) source;

		this.action = leBouton.getActionCommand();

		this.leControleur.action();
	}

	@Override
	public void setControleur(IControleur unControleur) {
		this.leControleur = unControleur;

	}

	@Override
	public String getAction() {
		return this.action;
	}

	@Override
	public double getMontant() throws SaisieInvalideException {
		double montant = 0;
		try {
			String texte = this.txtfld_montant.getText();
			montant = Double.valueOf(texte);

			if (montant <= 0) {
				throw new SaisieInvalideException();
			}
		} catch (NumberFormatException e) {
			throw new SaisieInvalideException();
		}
		
		return montant;
	}

	@Override
	public void demarrer() {
		this.montrerSolde(this.leControleur.getSolde());
		this.setVisible(true);
	}

	@Override
	public void montrerSolde(double solde) {
		String texte = String.valueOf(solde);
		this.lbl_solde.setText(texte);
	}

	@Override
	public void montrerSaisieInvalide() {
		this.lbl_resume.setText("Montant saisi invalide!");
	}

	@Override
	public void montrerFondInsuffisant() {
		this.lbl_resume.setText("Fonds insuffisants!");
	}

	@Override
	public void afficherOperation(double montant, String action) {
		String texte = "";

		if (action == "deposer") {
			texte += "Depot";
		} else {
			texte += "Retrait";
		}

		texte += " de " + montant + "$ effectue.";

		this.lbl_resume.setText(texte);
	}
}
