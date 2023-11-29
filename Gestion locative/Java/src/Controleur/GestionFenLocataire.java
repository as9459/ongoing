package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import Vue.FenLocataire;
import Vue.FenetrePrincipale;
import Vue.SaisirLocataire;

public class GestionFenLocataire implements ActionListener{

	private FenLocataire loca;
	
	public GestionFenLocataire(FenLocataire loca) {
		this.loca = loca;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		FenetrePrincipale fenb = (FenetrePrincipale) loca.getTopLevelAncestor();
		JButton botonn = (JButton) e.getSource();
		switch (botonn.getText()) {
			case "Retourner":
				loca.dispose();
				break;
			case "Ajouter":
				SaisirLocataire sloc = null;
			try {
				sloc = new SaisirLocataire();
				JLayeredPane layeredPane6 = fenb.getLayeredPane();
				layeredPane6.add(sloc, JLayeredPane.DEFAULT_LAYER);
				sloc.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
	            break;
	    	case "Modifier":
	    		SaisirLocataire mloc = null;
			try {
				mloc = new SaisirLocataire();
				JLayeredPane layeredPane5 = fenb.getLayeredPane();
				layeredPane5.add(mloc, JLayeredPane.DEFAULT_LAYER);
				mloc.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	            break;
		}
	}
}
