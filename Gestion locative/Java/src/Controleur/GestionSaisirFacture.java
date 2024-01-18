package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.FenBatiment;
import Vue.FenFacture;
import Vue.FenetrePrincipale;
/*import modele.Creneau;
import modele.Groupe;
import modele.dao.DaoCreneau;
import modele.dao.DaoGroupe;*/
import Vue.SaisirFacture;

public class GestionSaisirFacture implements ActionListener{

	private SaisirFacture sf;
	private FenetrePrincipale mere;
	private FenFacture fenefac;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirFacture(SaisirFacture sf, FenetrePrincipale mere, FenFacture fenefac) { 
		/*(SaisirBatiment sc, JTable tableC)*/
		this.sf = sf;
		this.mere = mere;
		this.fenefac = fenefac;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Inserer":
				int p_id_facture = this.sf.getIDfacture();
				String p_date_facture = this.sf.getDateFacture();
				String p_description= this.sf.getDescription();
	    	    float p_montantHT = this.sf.getmontantHT();
	    	    float p_tva = this.sf.getTVA();
	    	    String p_type = this.sf.getTypeFacture();
	    	    int p_siren = this.sf.getSiren();
	    	    System.out.println("check");
			try {
				this.mere.getConnectionBD().AddFacture(p_id_facture,
													   p_date_facture,
													   p_description,
													   p_montantHT,
													   p_tva,
													   p_type,
													   p_siren);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				this.sf.dispose();
				
				this.fenefac.dispose();
				
				fenefac = new FenFacture(this.mere);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(fenefac, JLayeredPane.DEFAULT_LAYER);
				fenefac.setVisible(true);
				break;
				
				
				/*Groupe groupe = daoGroupe.findById(this.sc.getTextFieldIdGrpC().getText());
				Creneau cr = new Creneau(this.sc.getTextFieldDebsemc().getText(),
										 this.sc.getTextFieldJourC().getText(), 
										 this.sc.getTextFieldHeureDC().getText(), 
										 this.sc.getTextFieldHeureFC().getText(), 
										 this.sc.getTextFieldTypeC().getText(), 
										 null,
										 groupe);
				new DaoCreneau().create(cr);
				modeleTable.addRow(new Object[] {
						cr.getDebsemc(), 
						cr.getJourc(),
						cr.getHeuredc(),
						cr.getHeurefc(),
						cr.getTypec(),
						cr.getGrpC().getGrpc()
				});;*/
				
			case "Annuler":
				this.sf.dispose();
				break;
			default:
				break;
		}
	}

}
