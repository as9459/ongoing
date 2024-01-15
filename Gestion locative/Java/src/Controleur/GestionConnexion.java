package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import jdbc.CictOracleDataSource;
import Vue.Connexion;
import Vue.FenBatiment;
import Vue.FenetrePrincipale;

public class GestionConnexion implements ActionListener {
	private FenetrePrincipale parent;
	private Connexion fen;

	public GestionConnexion(Connexion fen, FenetrePrincipale parent) {
		this.fen = fen;
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
			case "Annuler":
				fen.dispose();
				break;
			case "Connecter":
				FenetrePrincipale mere = (FenetrePrincipale) fen.getTopLevelAncestor();
				CictOracleDataSource bd = null;
				String msg="";
				fen.setMsgAcces(msg);
				
				try {
					bd = new CictOracleDataSource();
					msg = bd.creerAcces(fen.getValeurChLogin(), fen.getValeurPassword());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				fen.setMsgAcces(msg);
				if(msg=="Connexion etablie") {
					mere.setAcces(bd);
					mere.setEstConnecte(true);
					mere.activerItems(true);
					fen.dispose();
					parent.effacerPhoto();
		            parent.effacerTexte();
		            parent.effacerBoutonConnecter();
				}
                
				break;
		}
	}
}
