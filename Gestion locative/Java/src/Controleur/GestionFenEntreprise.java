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

import Vue.FenetrePrincipale;
import Vue.SaisirEntreprise;
import Controleur.GestionFenEntreprise;
import modele.Entreprise;
import modele.dao.DaoEntreprise;
import Vue.FenEntreprise;

public class GestionFenEntreprise implements ActionListener{
	private FenEntreprise fene;
	private FenetrePrincipale mere;
	
	public GestionFenEntreprise(FenEntreprise fen, FenetrePrincipale mere) {
		this.fene = fen;
		this.mere = mere ;
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
        JButton bouton =(JButton) e.getSource();
       
        if (fene != null) {
            JTable myTable = fene.getTableEntreprise();
            int selectedRow = myTable.getSelectedRow();
        
        
    	switch(bouton.getText()) {
  
    	case "Retourner":
    		fene.dispose();
    		break;
    	case "Ajouter":
			try {
				SaisirEntreprise sbat = new SaisirEntreprise(this.mere, this.fene);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(sbat, JLayeredPane.DEFAULT_LAYER);
				sbat.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
            break;
    	  case "Modifier":
             if (selectedRow != -1) {
                 // Récupérer les informations du Entreprise sélectionné
                 String sirenEntreprise = myTable.getValueAt(selectedRow, 0).toString();
                 String nomEntreprise = myTable.getValueAt(selectedRow, 1).toString();
                 String servesEntreprise = myTable.getValueAt(selectedRow, 2).toString();
                 String adresseEntreprise = myTable.getValueAt(selectedRow, 3).toString();
                 String cpEntreprise = myTable.getValueAt(selectedRow, 4).toString();
                 String ibanEntreprise = myTable.getValueAt(selectedRow, 5).toString();
                 String villeEntreprise = myTable.getValueAt(selectedRow, 6).toString();
                 String emailEntreprise = myTable.getValueAt(selectedRow, 7).toString();
                 String TelephoneEntreprise = myTable.getValueAt(selectedRow, 8).toString();

                 try {
                     SaisirEntreprise sbat = new SaisirEntreprise(this.mere, this.fene);
                     JLayeredPane layeredPane4 = this.mere.getLayeredPane();
                     layeredPane4.add(sbat, JLayeredPane.DEFAULT_LAYER);
                     sbat.setVisible(true);
                 } catch (ParseException e1) {
                     e1.printStackTrace();
                 }
             }
             break; 
        
    	case "Supprimer":
			// TODO
    		System.out.println("Vous voulez supprimer le " + (selectedRow+1) +"er/eme ligne");
    	

                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) myTable.getModel();

                    
                    Object idbat = model.getValueAt(selectedRow, 0); // recup Id Entreprise
                    Object addresse = model.getValueAt(selectedRow, 1);
                    String dateConstruction = model.getValueAt(selectedRow, 5).toString();
                    
                    System.out.println("Id Entreprise: " + idbat);
                    System.out.println("Adresse: " + addresse);
                    System.out.println("Date: " + dateConstruction);
                  
                    
                } else {
                    System.out.println("Aucun ligne est selectionner");
                }
            
			break;
			
		default:
			break;
    	}
        }
	}
    	

	
	public Object[][] updateTable() {
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().callGetTableData("Entreprise");

	        while (result.next()) {
	            Object[] row = new Object[9]; // Change the size as needed
	            row[0] = result.getString(1);
	            row[1] = result.getString(2);
	            row[2] = result.getString(3);
	            row[3] = result.getString(4);
	            row[4] = result.getString(5);
	            row[5] = result.getString(6);
	            row[6] = result.getString(7);
	            row[7] = result.getString(8);
	            row[8] = result.getString(9);
	            dataList.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	    }

	    
	    
	    Object[][] ob = new Object[dataList.size()][];
	    for (int i = 0; i < dataList.size(); i++) {
	        ob[i] = dataList.get(i);
	    }

	    return ob;
	}

	

}
