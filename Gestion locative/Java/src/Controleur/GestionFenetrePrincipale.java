package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import modele.Charges;
import Vue.Connexion;
import Vue.FenetrePrincipale;
import Vue.FenBatiment;
import Vue.FenFacture;
import Vue.FenLocataire;
import Vue.FenLogement;
import Vue.FenPaiement;
import Vue.FenCharges;
import Vue.FenEntreprise;

public class GestionFenetrePrincipale implements ActionListener{
	private FenetrePrincipale fen;

	public GestionFenetrePrincipale(FenetrePrincipale fen) {
		this.fen = fen;
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() instanceof JMenuItem) {
	        handleMenuItem((JMenuItem) e.getSource());
	    } else if (e.getSource() instanceof JButton) {
	        handleButton((JButton) e.getSource());
	    }
	}
	
	public void handleMenuItem(JMenuItem menuItem) {
		String actionCommand = menuItem.getText();
	    switch (actionCommand) {
			case "Quitter":
				fen.dispose();
				break;
			case "Connecter":
				showConnectionWindow();
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
				FenPaiement pmt = new FenPaiement(this.fen);
				JLayeredPane layeredPane2 = fen.getLayeredPane();
				layeredPane2.add(pmt, JLayeredPane.DEFAULT_LAYER);
				pmt.setVisible(true);
				break;
			case "Logement":
				FenLogement lgt = new FenLogement(this.fen);
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
			case "Entreprise":
				FenEntreprise ent = new FenEntreprise(this.fen);
				JLayeredPane layeredPane5 = fen.getLayeredPane();
				layeredPane5.add(ent, JLayeredPane.DEFAULT_LAYER);
				ent.setVisible(true);
			  break;
			case "Facture":
				FenFacture fac = new FenFacture(this.fen);
				JLayeredPane layeredPane6 = fen.getLayeredPane();
				layeredPane6.add(fac, JLayeredPane.DEFAULT_LAYER);
				fac.setVisible(true);
	            break;
			case "Calcul charges":
				System.out.println("Calcul Charges");
				FenCharges charg = new FenCharges(this.fen);
				JLayeredPane layeredPane7 = fen.getLayeredPane();
				layeredPane7.add(charg, JLayeredPane.DEFAULT_LAYER);
				charg.setVisible(true);
	            break;
		}      
	}
	
	private void handleButton(JButton button) {
	    String actionCommand = button.getText();

	    if ("Connecter".equals(actionCommand)) {
	        showConnectionWindow();
	    }
	}
	
	private void showConnectionWindow() {
	    Connexion connexion = new Connexion(this.fen);
	    JLayeredPane layeredPane = fen.getLayeredPane();
	    layeredPane.add(connexion, JLayeredPane.DEFAULT_LAYER);
	    connexion.setVisible(true);
	}
		
}
