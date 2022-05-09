import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

class MaFenetre extends JFrame implements ActionListener {

	JLabel lbl;

	public MaFenetre(String titre) {
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(1920 + 300, 50);
		this.setSize(400, 400);

		this.setLayout(new GridLayout(2, 1));
		this.lbl = new JLabel("Rien...");
		this.add(lbl);
		JButton btn = new JButton("Click me!");
		btn.addActionListener(this);
		this.add(btn);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.lbl.setText("COUCOU !");
	}
}

public class principale {
	public static void main(String[] args) {
		new MaFenetre("Ma super fenetre!");
		new MaFenetre("Ma super fenetre!");
	}
}
