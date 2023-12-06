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

import Vue.FenBatiment;
import Vue.FenLocataire;
import Vue.FenetrePrincipale;
import Vue.SaisirLocataire;

public class GestionFenLocataire implements ActionListener{
	private FenLocataire fene;
	private FenetrePrincipale mere ;

	public GestionFenLocataire(FenLocataire fen, FenetrePrincipale mare) {
		this.fene = fen;
		this.mere = mare ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        JButton bouton =(JButton) e.getSource();
    	switch(bouton.getText()) {
  
    	case "Retourner":
    		fene.dispose();
    		break;
    	case "Ajouter":
			SaisirLocataire sloc = null;
			try {
				sloc = new SaisirLocataire();
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(sloc, JLayeredPane.DEFAULT_LAYER);
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
				JLayeredPane layeredPane5 = this.mere.getLayeredPane();
				layeredPane5.add(mloc, JLayeredPane.DEFAULT_LAYER);
				mloc.setVisible(true);
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
	        result = this.mere.getConnectionBD().callGetTableData("LOCATAIRE");

	        while (result.next()) {
	            Object[] row = new Object[7]; // Change the size as needed
	            row[0] = result.getString(2);
	            row[1] = result.getString(3);
	            row[2] = result.getString(4);
	            row[3] = result.getString(5);
	            row[4] = result.getString(6);
	            row[5] = this.mere.getConnectionBD().callGetLogementIdByLocateur(result.getInt(1));;
	            row[6] = null;
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
