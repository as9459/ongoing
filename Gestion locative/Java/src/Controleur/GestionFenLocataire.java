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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.FenFacture;
import Vue.FenLocataire;
import Vue.FenetrePrincipale;
import Vue.SaisirLocataire;
import Vue.SaisirPaiement;

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
        
        if (fene != null) {
            JTable myTable = fene.getTableLocataire();
            int selectedRow = myTable.getSelectedRow();
            
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
			
            String sIdLocataire = myTable.getValueAt(selectedRow, 0).toString();
            String sNom = myTable.getValueAt(selectedRow, 1).toString();
            String sPrenom = myTable.getValueAt(selectedRow, 2).toString();
            String sTele = myTable.getValueAt(selectedRow, 3).toString();
            String sDateNaissance = myTable.getValueAt(selectedRow, 4).toString();
            String sStatut = myTable.getValueAt(selectedRow, 5).toString();
				
            try {
                mloc = new SaisirLocataire();
                mloc.loadPaiementInfo(sNom, sPrenom, sTele, sDateNaissance, sStatut);
				JLayeredPane layeredPane5 = this.mere.getLayeredPane();
				layeredPane5.add(mloc, JLayeredPane.DEFAULT_LAYER);
				mloc.setVisible(true);
             } catch (ParseException e1) {
                 e1.printStackTrace();
             }
        break; 
        
    	case "Supprimer":
			// TODO
    		System.out.println("Vous voulez supprimer le " + (selectedRow+1) +"er/eme ligne");
    	

                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) myTable.getModel();

                    
                    Object idloc = model.getValueAt(selectedRow, 0); // recup Id Batiment
                    Object nom = model.getValueAt(selectedRow, 1);
                    //test
                    System.out.println("Id Locataire: " + idloc);
                    System.out.println("nom: " + nom);
                    
                } else {
                    System.out.println("Aucun ligne est selectionner");
                }
          break;
    	}
		
		}
    
	}

	
	public Object[][] updateTable() {
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().callGetLocatairesActuels();

	        while (result.next()) {
	            Object[] row = new Object[8]; // Change the size as needed
	            row[0] = result.getString(1);
	            row[1] = result.getString(2);
	            row[2] = result.getString(3);
	            row[3] = result.getString(4);
	            row[4] = result.getString(5);
	            row[5] = result.getString(6);
	            row[6] = this.mere.getConnectionBD().callGetLogementIdByLocateur(result.getInt(1));;
	            row[7] = null;
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
