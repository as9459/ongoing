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
import Controleur.GestionFenBatiment;
import modele.Batiment;
import modele.dao.DaoBatiment;
import Vue.FenBatiment;

public class GestionFenBatiment implements ActionListener{
	private FenBatiment fene;
	private FenetrePrincipale mere;
	private static ArrayList<String> idvalues;
	//private DefaultTableModel modeleTable;

	public GestionFenBatiment(FenBatiment fen, FenetrePrincipale mere) {
		this.fene = fen;
		this.mere = mere ;
		//this.modeleTable = (DefaultTableModel) this.fene.getTableBatiment().getModel();
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
       
        if (fene != null) {
            JTable myTable = fene.getTableBatiment();
            int selectedRow = myTable.getSelectedRow();
        
        
    	switch(bouton.getText()) {
  
    	case "Retourner":
    		fene.dispose();
    		break;
    	case "Ajouter":
			try {
				SaisirBatiment sbat = new SaisirBatiment(this.mere, this.fene);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(sbat, JLayeredPane.DEFAULT_LAYER);
				sbat.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
            break;
    	/*case "Modifier":
			SaisirBatiment mbat = null;
			try {
				mbat = new SaisirBatiment(this mere);
				JLayeredPane layeredPane5 = this.mere.getLayeredPane();
				layeredPane5.add(mbat, JLayeredPane.DEFAULT_LAYER);
				mbat.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            break;*/
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
                    /*
                    // Delete the row from the database
                    int idBatimentToDelete = Integer.parseInt(idbat.toString());
                    if (this.mere.getConnectionBD().deleteBatimentById(idBatimentToDelete)) {
                        // If deletion is successful, remove the row from the table
                        model.removeRow(selectedRow);
                        System.out.println("Succes suppression du ligne");
                    } else {
                        System.out.println("Error erreur suppression ligne");
                    }*/
                    
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
		idvalues = new ArrayList<String>();
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().callGetTableData("BATIMENT");

	        while (result.next()) {
	            Object[] row = new Object[8]; // Change the size as needed
	            row[0] = result.getString(1);
	            idvalues.add(result.getString(1));
	            row[1] = result.getString(2);
	            row[2] = result.getString(3);
	            row[3] = result.getString(4);
	            row[4] = result.getString(5);
	            row[5] = result.getString(6);
	            row[6] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getInt(1));
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

	public static ArrayList<String> getIdvalues() {
		return idvalues;
	}
	

}
