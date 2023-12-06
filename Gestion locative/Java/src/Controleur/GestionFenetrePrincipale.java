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

public class GestionFenetrePrincipale implements ActionListener{
	private FenetrePrincipale fen;

	public GestionFenetrePrincipale(FenetrePrincipale fen) {
		this.fen = fen;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem itemm = (JMenuItem) e.getSource();
		switch (itemm.getText()) {
			case "Quitter":
				fen.dispose();
				break;
			case "Connecter":
				Connexion cn = new Connexion();
				JLayeredPane layeredPane0 = fen.getLayeredPane();
				layeredPane0.add(cn, JLayeredPane.DEFAULT_LAYER);
				cn.setVisible(true);
				break;
			case "Déconnecter":
				fen.deconnecter();
				fen.setEstConnecte(false);
				fen.activerItems(false);
				fen.removeFen();
				break;
			case "Locataire":
				FenLocataire loca = new FenLocataire(this.fen);
				JLayeredPane layeredPane1 = fen.getLayeredPane();
				layeredPane1.add(loca, JLayeredPane.DEFAULT_LAYER);
				loca.setVisible(true);
				break;
			case "Paiement":
				FenPaiement pmt = new FenPaiement();
				JLayeredPane layeredPane2 = fen.getLayeredPane();
				layeredPane2.add(pmt, JLayeredPane.DEFAULT_LAYER);
				pmt.setVisible(true);
				break;
			case "Logement":
				FenLogement lgt = new FenLogement();
				JLayeredPane layeredPane3 = fen.getLayeredPane();
				layeredPane3.add(lgt, JLayeredPane.DEFAULT_LAYER);
				lgt.setVisible(true);
				break;
			case "Batiment":
				FenBatiment bat = new FenBatiment(this.fen);
				JLayeredPane layeredPane4 = fen.getLayeredPane();
				layeredPane4.add(bat, JLayeredPane.DEFAULT_LAYER);
				bat.setVisible(true);
	            break;
		}
	}}
