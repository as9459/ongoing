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
import Vue.SaisirBatiment;
import Vue.SaisirFacture;
import Controleur.GestionFenFacture;
import modele.Batiment;
import modele.dao.DaoBatiment;
import Vue.FenFacture;

public class GestionFenFacture implements ActionListener{
	private FenFacture fac;
	private FenetrePrincipale mere;
	/*private DaoBatiment daoBatiment;
	private DefaultTableModel modeleTable;*/

	public GestionFenFacture(FenFacture fen, FenetrePrincipale mere) {
		this.fac = fen;
		/*this.daoBatiment = new DaoBatiment();*/
		this.mere = mere ;
		///if (this.fac.getTableBatiment().getModel() != null) {
	      //this.modeleTable = (DefaultTableModel) this.fac.getTableBatiment().getModel();
		//}
	}
	
	/*
	public Batiment lireLigneTable(int index) {
		Batiment bat = new Batiment((int) this.modeleTable.getValueAt(index, 0),
								 (String) this.modeleTable.getValueAt(index, 1),
								 (String) this.modeleTable.getValueAt(index, 2),
								 (String) this.modeleTable.getValueAt(index, 3), 
								 (String) String.valueOf(this.modeleTable.getValueAt(index, 4)),
								 (String) String.valueOf(this.modeleTable.getValueAt(index, 5)));
		
								 //(Groupe) new DaoGroupe().findById((String) this.modeleTable.getValueAt(index,5)));
		return bat;
	}*/
	

	@Override
	public void actionPerformed(ActionEvent e) {
        JButton bouton =(JButton) e.getSource();
       
        if (fac != null) {
            JTable myTable = fac.getTableBatiment();
            int selectedRow = myTable.getSelectedRow();
        
        
    	switch(bouton.getText()) {
  
    	case "Retourner":
    		fac.dispose();
    		break;
    	case "Ajouter":
			SaisirFacture sfact = null;
			try {
				sfact = new SaisirFacture();
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(sfact, JLayeredPane.DEFAULT_LAYER);
				sfact.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
            break;
    	case "Modifier":
			SaisirBatiment mbat = null;
			try {
				mbat = new SaisirBatiment();
				JLayeredPane layeredPane5 = this.mere.getLayeredPane();
				layeredPane5.add(mbat, JLayeredPane.DEFAULT_LAYER);
				mbat.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            break;
    	case "Supprimer":
			// TODO
    		System.out.println("Vous voulez supprimer le " + (selectedRow+1) +"er/eme ligne");
    	

                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) myTable.getModel();

                    
                    Object idbat = model.getValueAt(selectedRow, 0); // recup Id Batiment
                    Object addresse = model.getValueAt(selectedRow, 1);
                    
                    
                    //test
                    System.out.println("Id batiment: " + idbat);
                    System.out.println("Adresse: " + addresse);
                    
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
	        result = this.mere.getConnectionBD().callGetTableData("FACT_BATIMENT");

	        while (result.next()) {
	            Object[] row = new Object[8]; // Change the size as needed
	            row[0] = result.getInt(1);
	            row[1] = result.getInt(2);
	            row[2] = result.getString(3);
	            row[3] = result.getFloat(4);
	            row[4] = result.getString(5);
	            row[5] = result.getDate(6);
	           // row[6] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getInt(1));
	           // row[7] = null;
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