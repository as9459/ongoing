package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import modele.Charges;
import Vue.Connexion;
import Vue.FenetrePrincipale;
import Vue.SaisirBatiment;
import Vue.FenBatiment;
import Vue.FenDocument;
import Vue.FenLocataire;
import Vue.FenLogement;
import Vue.FenPaiement;

public class GestionFenBatiment implements ActionListener{
	private FenBatiment fene;

	public GestionFenBatiment(FenBatiment fen) {
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
			SaisirBatiment sbat = new SaisirBatiment();
			JLayeredPane layeredPane4 = fen.getLayeredPane();
			layeredPane4.add(sbat, JLayeredPane.DEFAULT_LAYER);
			sbat.setVisible(true);
			
            break;
    	case "Modifier":
			SaisirBatiment mbat = new SaisirBatiment();
			JLayeredPane layeredPane5 = fen.getLayeredPane();
			layeredPane5.add(mbat, JLayeredPane.DEFAULT_LAYER);
			mbat.setVisible(true);
            break;
		
		}
    
	}
}