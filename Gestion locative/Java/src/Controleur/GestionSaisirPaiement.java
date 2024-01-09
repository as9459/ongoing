package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.FenBatiment;
import Vue.FenPaiement;
import Vue.FenetrePrincipale;
/*import modele.Creneau;
import modele.Groupe;
import modele.dao.DaoCreneau;
import modele.dao.DaoGroupe;*/
import Vue.SaisirPaiement;

public class GestionSaisirPaiement implements ActionListener{

	private SaisirPaiement sp;
	private FenetrePrincipale mere;
	private FenPaiement fenepaie;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirPaiement(SaisirPaiement sp, FenetrePrincipale mere, FenPaiement fenepaie) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sp = sp;
		this.mere = mere;
		this.fenepaie = fenepaie;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Inserer":
				int p_id_facture = this.sp.getIdFacture();
				int p_id_batiment = this.sp.getIdBatiment();
				int p_id_logement = this.sp.getIdLogement();
				String p_reference_du_paiement = this.sp.getRefPaiement();
				float p_paiement = this.sp.getMontantPaiement();
				String p_type_paiement = this.sp.getTypePaiement();
				String p_date_de_paiement = this.sp.getDatePaiement();
				int p_id_locataire = this.sp.getIdLocataire();
			try {
				this.mere.getConnectionBD().AddPaiement(p_id_facture,
				    	  								p_id_batiment,
				    	  								p_id_logement,
				    	  								p_reference_du_paiement,
				    	  								p_paiement,
				    	  								p_type_paiement,
				    	  								p_date_de_paiement,
				    	  								p_id_locataire);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				this.sp.dispose();
				
				this.fenepaie.dispose();
				
				fenepaie = new FenPaiement(this.mere);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(fenepaie, JLayeredPane.DEFAULT_LAYER);
				fenepaie.setVisible(true);
				
				break;
			case "Annuler":
				this.sp.dispose();
				break;
			default:
				break;
		}
	}

}
