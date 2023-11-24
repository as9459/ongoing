package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Connexion;
import Vue.FenBatiment;
import Vue.FenetrePrincipale;

public class GestionConnexion implements ActionListener {
	
	private Connexion fen;

	public GestionConnexion(Connexion fen) {
		this.fen = fen;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Annuler":
				fen.dispose();
				break;
			case "Connecter":
				FenetrePrincipale mere = (FenetrePrincipale) fen.getTopLevelAncestor();
				mere.setEstConnecte(true);
				mere.activerItems(true);
				fen.dispose();
				break;
		}
	}
}
