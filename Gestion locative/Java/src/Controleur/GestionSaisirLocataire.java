package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.FenBatiment;
import Vue.FenLocataire;
import Vue.FenetrePrincipale;
/*import modele.Creneau;
import modele.Groupe;
import modele.dao.DaoCreneau;
import modele.dao.DaoGroupe;*/
import Vue.SaisirLocataire;

public class GestionSaisirLocataire implements ActionListener{

	private SaisirLocataire sl;
	private FenetrePrincipale mere;
	private FenLocataire fenloca;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirLocataire(SaisirLocataire sl, FenetrePrincipale mere, FenLocataire fenloca) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sl = sl;
		this.mere = mere;
		this.fenloca = fenloca;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Inserer":
				String p_nom = this.sl.getNom() ;
				String p_prenom = this.sl.getPrenom();
				String p_date_de_naissance= this.sl.getDate();
	    	    String p_telephone = this.sl.getTel();
	    	    String p_email = this.sl.getMail();
	    	    String p_statut = this.sl.getStatut();
			try {
				this.mere.getConnectionBD().AddLocataire(p_nom, 
	    	    										p_prenom, 
	    	    										p_date_de_naissance, 
	    	    										p_telephone, 
	    	    										p_email, 
	    	    										p_statut);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
				
				this.sl.dispose();

				this.fenloca.dispose();
				
				fenloca = new FenLocataire(this.mere);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(fenloca, JLayeredPane.DEFAULT_LAYER);
				fenloca.setVisible(true);
				
				break;
			case "Annuler":
				this.sl.dispose();
				break;
			default:
				break;
		}
	}

}
