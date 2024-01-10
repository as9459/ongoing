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
import Vue.SaisirLocataire;
import Vue.SaisirLogement;
import Controleur.GestionFenFacture;
import modele.Batiment;
import modele.dao.DaoBatiment;
import Vue.FenFacture;

public class GestionFenFacture implements ActionListener{
	private FenFacture fac;
	private FenetrePrincipale mere;
	//private DefaultTableModel modeleTable;

	public GestionFenFacture(FenFacture fac, FenetrePrincipale mare) {
		this.fac = fac;
		this.mere = mare ;
		//this.modeleTable = (DefaultTableModel) this.fac.getTableFacture().getModel();
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
            JTable myTable = fac.getTableFacture();
            int selectedRow = myTable.getSelectedRow();
        
        
    	switch(bouton.getText()) {
  
    	case "Retourner":
    		fac.dispose();
    		break;
    	case "Ajouter":
			SaisirFacture sfac = null;
			try {
				sfac = new SaisirFacture(mere, fac);
				JLayeredPane layeredPane4 = this.mere.getLayeredPane();
				layeredPane4.add(sfac, JLayeredPane.DEFAULT_LAYER);
				sfac.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
            break;
         
    	case "Modifier":
    		
    		if (selectedRow != -1) {
                 // Récupérer les informations du batiment sélectionné
                 String idfacture = myTable.getValueAt(selectedRow, 0).toString();
                 String idbatiment = myTable.getValueAt(selectedRow, 1).toString();
                 String refpaiement = myTable.getValueAt(selectedRow, 2).toString();
                 String paiement = myTable.getValueAt(selectedRow, 3).toString();
                 String type = myTable.getValueAt(selectedRow, 4).toString();
                 String date = myTable.getValueAt(selectedRow, 5).toString();
                 System.out.println("ID facture:" + idfacture + " ID batiment:" +idbatiment + " ref paiement:" +refpaiement + 
                		 " Paiement:" +paiement + " Type:" +type + " Date:" +date);
                 
                 try {
	                SaisirFacture mfac = new SaisirFacture(this.mere, this.fac);
	                mfac.loadFactureInfo(idfacture, idbatiment, refpaiement, paiement, type, date);
					JLayeredPane layeredPane5 = this.mere.getLayeredPane();
					layeredPane5.add(mfac, JLayeredPane.DEFAULT_LAYER);
					mfac.setVisible(true);
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

                    
                    Object idfac = model.getValueAt(selectedRow, 0); // recup Id Batiment
                    Object ref = model.getValueAt(selectedRow, 2);
                    
                    
                    //test
                    System.out.println("Id batiment: " + idfac);
                    System.out.println("Adresse: " + ref);
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
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().callGetTableData("FACTURE");

	        while (result.next()) {
	            Object[] row = new Object[8]; // Change the size as needed
	            row[0] = result.getInt(1);
	            row[1] = result.getDate(2);
	            row[2] = result.getString(3);
	            row[3] = result.getFloat(4);
	            row[4] = result.getFloat(5);
	            row[5] = result.getString(6);
	            row[6] = result.getString(7);       //row[6] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getInt(1));
	            //row[7] = null;
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
