package vue;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Controleur;
import modele.Produit;

public class PanierAchatUI extends JFrame implements ActionListener {
	private Controleur leControleur;

	private JComboBox<Produit> cbx_produits;
	private JTextField txtfld_quantite;
	private JTextArea txtarea_panier;

	public PanierAchatUI(String titre) {
		super(titre);

		this.setSize(400, 400);
		this.setLocation(1920 + 200, 200);
		this.setLayout(new FlowLayout());

		// liste des produits disponibles
		this.cbx_produits = new JComboBox<Produit>();
		this.add(this.cbx_produits);

		// zone de saisie de la quantite
		this.txtfld_quantite = new JTextField(5);
		this.add(this.txtfld_quantite);

		// bouton d'ajout au panier
		JButton btn_ajouter = new JButton("Ajouter");
		btn_ajouter.addActionListener(this);
		this.add(btn_ajouter);

		// zone d'affichage des produits du panier
		this.txtarea_panier = new JTextArea(10, 20);
		this.add(new JScrollPane(this.txtarea_panier));

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		leControleur.action();
	}

	public void montrerPanier(Hashtable<Integer, Produit> liste) {
		String texte = "";
		for (Produit p : liste.values()) {
			texte += p + "\n";
		}
		this.txtarea_panier.setText(texte);
		
		this.cbx_produits.setVisible(false);
		this.cbx_produits.setVisible(true);
	}

	public void setControleur(Controleur unControleur) {
		this.leControleur = unControleur;

		Hashtable<Integer, Produit> liste = this.leControleur.getProduitsMagasin();
		for (Produit p : liste.values()) {
			this.cbx_produits.addItem(p);
		}
	}

	public Produit getProduitSelectionne() {
		return (Produit) this.cbx_produits.getSelectedItem();
	}

	public int getQuantiteDemandee() {
		return Integer.valueOf(this.txtfld_quantite.getText());
	}

	public static void main(String[] args) {
		new PanierAchatUI("Panier d'achat");
	}
}
