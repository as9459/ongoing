package Vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;

import Controleur.GestionConnexion;
import Controleur.GestionFenBatiment;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private GestionConnexion GestionClic;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Connexion() {
		setTitle("Connexion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(236, 86, 153, 20);
		getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 130, 153, 20);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(97, 92, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mots de passe:");
		lblNewLabel_1.setBounds(58, 132, 128, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Connecter");
		this.GestionClic = new GestionConnexion(this);
		btnNewButton.addActionListener(this.GestionClic);
		btnNewButton.setBounds(78, 198, 108, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		this.GestionClic = new GestionConnexion(this);
		btnNewButton_1.addActionListener(this.GestionClic);
		btnNewButton_1.setBounds(220, 198, 108, 23);
		getContentPane().add(btnNewButton_1);

	}
	/*
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Annuler":
				dispose();
				break;
			case "Connecter":
				FenetrePrincipale mere = (FenetrePrincipale) this.getTopLevelAncestor();
				mere.setEstConnecte(true);
				mere.activerItems(true);
				dispose();
				break;
		}
	}*/
}