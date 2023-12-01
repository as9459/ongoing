package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import modele.Charges;
import Vue.Connexion;
import Vue.FenetrePrincipale;
import Vue.SaisirPaiement;
import Vue.FenPaiement;
import Vue.FenDocument;
import Vue.FenLocataire;
import Vue.FenLogement;
import Vue.FenPaiement;

public class GestionFenPaiement implements ActionListener{
	private FenPaiement fene;

	public GestionFenPaiement(FenPaiement fen) {
		this.fene = fen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FenetrePrincipale fen = (FenetrePrincipale) fene.getTopLevelAncestor();
        JButton bouton =(JButton) e.getSource();
    	switch(bouton.getText()) {
  
    	case "Retourner":
    		fene.dispose();
    		break;
    	case "Ajouter":
			SaisirPaiement sbat = null;
			try {
				sbat = new SaisirPaiement();
				JLayeredPane layeredPane4 = fen.getLayeredPane();
				layeredPane4.add(sbat, JLayeredPane.DEFAULT_LAYER);
				sbat.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
            break;
    	case "Modifier":
			SaisirPaiement mbat = null;
			try {
				mbat = new SaisirPaiement();
				JLayeredPane layeredPane5 = fen.getLayeredPane();
				layeredPane5.add(mbat, JLayeredPane.DEFAULT_LAYER);
				mbat.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            break;
		
		}
    
	}
}