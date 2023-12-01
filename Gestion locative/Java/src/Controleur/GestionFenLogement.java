package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import Vue.FenLogement;
import Vue.FenetrePrincipale;
import Vue.SaisirLogement;

public class GestionFenLogement implements ActionListener{

	private FenLogement log;
	
	public GestionFenLogement(FenLogement log) {
		this.log = log;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		FenetrePrincipale fenlog = (FenetrePrincipale) log.getTopLevelAncestor();
		JButton botonn = (JButton) e.getSource();
		switch (botonn.getText()) {
			case "Retourner":
				log.dispose();
				break;
			case "Ajouter":
				SaisirLogement slog = new SaisirLogement();
				JLayeredPane layeredPane8 = fenlog.getLayeredPane();
				layeredPane8.add(slog, JLayeredPane.DEFAULT_LAYER);
				slog.setVisible(true);
	            break;
	            
	            
	    	case "Modifier":
				SaisirLogement mlog = new SaisirLogement();
				JLayeredPane layeredPane5 = fenlog.getLayeredPane();
				layeredPane5.add(mlog, JLayeredPane.DEFAULT_LAYER);
				mlog.setVisible(true);
	            break;
		}
	}
}