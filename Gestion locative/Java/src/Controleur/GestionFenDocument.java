package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import modele.Charges;
import Vue.Connexion;
import Vue.FenetrePrincipale;
import Vue.FenBatiment;
import Vue.FenDocument;
import Vue.FenLocataire;
import Vue.FenLogement;
import Vue.FenPaiement;

public class GestionFenDocument implements ActionListener{
	private FenDocument fen;
	
	public GestionFenDocument(FenDocument fen) {
		this.fen = fen;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fen.dispose();
		JButton botonn = (JButton) e.getSource();
		switch (botonn.getText()) {
			case "Retourner":
				fen.dispose();
				break;
		}
	}
}