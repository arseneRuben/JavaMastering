import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FenetreRH extends JFrame {
	private final static int GAUCHE = 1920 + 300;
	private final static int HAUT = 100;
	private final static int LONGUEUR = 800;
	private final static int HAUTEUR = 600;

	private final static int LABEL_SANS_SAISIE = -1;

	private final static Font LA_FONTE = new Font("courrier", Font.BOLD, 18);

//	private void ajouterLabel(String texte) {
//		JPanel pnl = new JPanel();
//		JLabel lbl = new JLabel(texte);
//		lbl.setFont(FenetreRH.laFonte);
//		pnl.add(lbl);
//		this.add(pnl);
//	}

	/**
	 * Ajoute un label avec une zone de saisie optionnelle a la fenetre
	 * 
	 * @param texte      Le label
	 * @param nbColonnes Le nombre de colonnes de la zone de saisie (-1 si on ne
	 *                   veut pas de zone de saisie)
	 */
	private void ajouterLabelAvecSaisie(String texte, int nbColonnes) {
		JPanel pnl = new JPanel();

		JLabel lbl = new JLabel(texte);
		lbl.setFont(FenetreRH.LA_FONTE);
		pnl.add(lbl);

		if (nbColonnes != FenetreRH.LABEL_SANS_SAISIE) {
			JTextField txtfld = new JTextField(nbColonnes);
			txtfld.setFont(FenetreRH.LA_FONTE);
			pnl.add(txtfld);
		}

		this.add(pnl);
	}

	private void ajouterBouton(JPanel pnl, String texte) {
		JButton btn = new JButton(texte);
		btn.setFont(FenetreRH.LA_FONTE);
		pnl.add(btn);
	}

	public FenetreRH(String titre) {
		super(titre);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(FenetreRH.GAUCHE, FenetreRH.HAUT);
		this.setSize(FenetreRH.LONGUEUR, FenetreRH.HAUTEUR);

		this.setLayout(new GridLayout(11, 1));

		// this.add(new JLabel("No:")); // pour Ho

		// Label pour le numero de l'emplyoe
		this.ajouterLabelAvecSaisie("No :", FenetreRH.LABEL_SANS_SAISIE);
//		JPanel pnl_no = new JPanel();
//		pnl_no.add(new JLabel("No:"));
//		this.add(pnl_no);

		// Zone de saisie du nom de l'employe
		this.ajouterLabelAvecSaisie("Nom :", 30);
//		JPanel pnl_nom = new JPanel();
//		pnl_nom.add(new JLabel("Nom :"));
//		pnl_nom.add(new JTextField(30));
//		this.add(pnl_nom);

		// Zone de saisie du prenom de l'employe
		this.ajouterLabelAvecSaisie("Prenom :", 30);

		// Zone de saisie de l'age de l'employe
		this.ajouterLabelAvecSaisie("Age :", 5);

		// Radio boutons pour permanent et contractuel
		JPanel pnl;

		pnl = new JPanel();
		JRadioButton rdbtn_perm = new JRadioButton("Permanent");
		rdbtn_perm.setFont(FenetreRH.LA_FONTE);
		pnl.add(rdbtn_perm);
		this.add(pnl);

		pnl = new JPanel();
		JRadioButton rdbtn_contract = new JRadioButton("Contractuel");
		rdbtn_contract.setFont(FenetreRH.LA_FONTE);
		pnl.add(rdbtn_contract);
		this.add(pnl);

		// Les 2 radio bouton font partie du meme groupe
		// un seul peut etre selectionne a la fois
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn_perm);
		group.add(rdbtn_contract);

		// Label pour le salaire de l'employe
		this.ajouterLabelAvecSaisie("Salaire/Tarif :", 30);

		// Label pour l'anciennete de l'employe
		this.ajouterLabelAvecSaisie("Nb jours/Annees :", 30);

		// les 4 boutons de l'interface
		JPanel pnl_boutons = new JPanel();

		ajouterBouton(pnl_boutons, "Ajouter");
//		JButton btn_ajouter = new JButton("Ajouter");
//		btn_ajouter.setFont(FenetreRH.LA_FONTE);
//		pnl_boutons.add(btn_ajouter);

		ajouterBouton(pnl_boutons, "Retirer");
		ajouterBouton(pnl_boutons, "Afficher");
		ajouterBouton(pnl_boutons, "Quitter");

		this.add(pnl_boutons);

		// Label pour la capacite de l'employe (?)
		this.ajouterLabelAvecSaisie("Capacite :", FenetreRH.LABEL_SANS_SAISIE);

		// Label pour la taille de l'employe
		this.ajouterLabelAvecSaisie("Taille :", FenetreRH.LABEL_SANS_SAISIE);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FenetreRH("Ressources Humaines");

	}

}
