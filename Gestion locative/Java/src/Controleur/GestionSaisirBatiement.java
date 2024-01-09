package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.FenBatiment;
import Vue.FenetrePrincipale;
import Vue.SaisirBatiment;
import jdbc.CictOracleDataSource;

public class GestionSaisirBatiement implements ActionListener{

	private SaisirBatiment sb;
	private FenetrePrincipale mere;
	private FenBatiment feneb;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirBatiement(SaisirBatiment sb, FenetrePrincipale mere, FenBatiment feneb){ /*(SaisirBatiment sc, JTable tableC)*/
		this.sb = sb;
		this.mere = mere;
		this.feneb = feneb;
		
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Inserer":
				System.out.println("Ici");
				String p_id_batiment = this.sb.getTextFieldIDbat()  ;
				String p_adresse = this.sb.getTextFd_Adresse();
				int p_code_postal= this.sb.getTextFieldCP();
	    	    String p_ville = this.sb.getTextFieldVille();
	    	    String p_regime_juridique = this.sb.getFieldRegimeJuridique();
	    	    String p_date_construction = this.sb.getTextFieldDateConstruction();
			try {
				this.mere.getConnectionBD().AddBatiment(p_id_batiment, 
	    	    										p_adresse, 
	    	    										p_code_postal, 
	    	    										p_ville, 
	    	    										p_regime_juridique, 
	    	    										p_date_construction);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				this.sb.dispose();
				
				this.feneb.dispose();
				
				feneb = new FenBatiment(this.mere);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(feneb, JLayeredPane.DEFAULT_LAYER);
				feneb.setVisible(true);
				break;
			case "Annuler":
				this.sb.dispose();
				break;
			default:
				break;
		}
	}

}

