package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.CictOracleDataSource;
import Vue.FenBatiment;
import Vue.FenLogement;
import Vue.FenetrePrincipale;
/*import modele.Creneau;
import modele.Groupe;
import modele.dao.DaoCreneau;
import modele.dao.DaoGroupe;*/
import Vue.SaisirLogement;

public class GestionSaisirLogement implements ActionListener{

	private SaisirLogement sl;
	private FenetrePrincipale mere;
	private FenLogement fenelog;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirLogement(SaisirLogement sl, FenetrePrincipale mere, FenLogement fenelog) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sl = sl;
		this.fenelog = fenelog;
		this.mere = mere;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Inserer":
				int p_id_batiment = 1;
				int p_id_logement = this.sl.getTextFieldNbLogement();
				int p_etage = this.sl.getTextFieldEtage();
				String p_type = this.sl.getTextFieldTypeLogement();
				int p_surface = this.sl.getTextFieldSurface();
				int p_ICC = this.sl.getTextFieldICC();
				int p_colocation = 0;
				int p_garage = this.sl.getTextFieldGarage();
				int p_jardin = this.sl.getTextFieldJardin();
				int p_balcon =this.sl.getTextFieldBalcon();
				
			try {
				this.mere.getConnectionBD().AddLogement(p_id_batiment,
			    	      								p_id_logement,
			    	      								p_etage,
			    	      								p_type,
			    	      								p_surface,
			    	      								p_ICC,
			    	      								p_colocation,
			    	      								p_garage,
			    	      								p_jardin,
			    	      								p_balcon);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				this.sl.dispose();
				
				this.fenelog.dispose();
				
				fenelog = new FenLogement(this.mere);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(fenelog, JLayeredPane.DEFAULT_LAYER);
				fenelog.setVisible(true);
				
				break;
			case "Annuler":
				this.sl.dispose();
				break;
			default:
				break;
		}
	}

}
