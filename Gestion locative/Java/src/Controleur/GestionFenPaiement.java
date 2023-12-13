package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import modele.Charges;
import Vue.Connexion;
import Vue.FenetrePrincipale;
import Vue.SaisirPaiement;
import Vue.FenDocument;
import Vue.FenLocataire;
import Vue.FenLogement;
import Vue.FenPaiement;

public class GestionFenPaiement implements ActionListener{
	private FenPaiement fene;
	private FenetrePrincipale mere;

	public GestionFenPaiement(FenPaiement fen, FenetrePrincipale mere) {
		this.fene = fen;
		this.mere = mere;
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
	
	public Object[][] updateTable() {
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().getTableData("FACT_LOGEMENT");

	        while (result.next()) {
	            Object[] row = new Object[8]; // Change the size as needed
	            row[0] = result.getInt("ID_FACTURE");
	            row[1] = result.getString("ID_BATIMENT");
	            row[2] = result.getString("ID_LOGEMENT");
	            row[3] = result.getString("ID_LOCATAIRE");
	            row[4] = result.getString("REFERENCE_DU_PAIEMENT");
	            row[5] = result.getString("PAIEMENT");
	            row[6] = result.getString("TYPE_PAIMENT");
	            row[7] = result.getString("DATE_DE_PAIEMENT");
	            /*row[8] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getString(1));*/
	            dataList.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Do not close the ResultSet here
	    }

	    // Convert the list to a 2D array
	    Object[][] ob = new Object[dataList.size()][];
	    for (int i = 0; i < dataList.size(); i++) {
	        ob[i] = dataList.get(i);
	    }

	    return ob;
	}
}