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

import Vue.FenLogement;
import Vue.FenetrePrincipale;
import Vue.SaisirBatiment;
import Vue.SaisirLogement;

public class GestionFenLogement implements ActionListener{

	private FenLogement log;
	private FenetrePrincipale mere;
	
	public GestionFenLogement(FenLogement log, FenetrePrincipale mere) {
		this.mere = mere;
		this.log = log;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		FenetrePrincipale fenlog = (FenetrePrincipale) log.getTopLevelAncestor();
		JButton botonn = (JButton) e.getSource();
		
		 if (log != null) {
	            JTable myTable = log.getTableLogement();
	            int selectedRow = myTable.getSelectedRow();
		
		switch (botonn.getText()) {
			case "Retourner":
				log.dispose();
				break;
			case "Ajouter":
				SaisirLogement slog = new SaisirLogement(this.mere, this.log);
				JLayeredPane layeredPane8 = fenlog.getLayeredPane();
				layeredPane8.add(slog, JLayeredPane.DEFAULT_LAYER);
				slog.setVisible(true);
	            break;
	            
	    	case "Modifier":
				SaisirLogement mlog = null;
				mlog = new SaisirLogement(this.mere, this.log);
				JLayeredPane layeredPane5 = this.mere.getLayeredPane();
				layeredPane5.add(mlog, JLayeredPane.DEFAULT_LAYER);
				mlog.setVisible(true);
	            break;
	    	case "Supprimer":
				// TODO
	    		System.out.println("Vous voulez supprimer le " + (selectedRow+1) +"er/eme ligne");
	    	

	                if (selectedRow != -1) {
	                    DefaultTableModel model = (DefaultTableModel) myTable.getModel();

	                    
	                    Object idlog = model.getValueAt(selectedRow, 0); // recup Id Batiment
	                    Object etage = model.getValueAt(selectedRow, 1);
	                    //test
	                    System.out.println("Id Logement: " + idlog);
	                    System.out.println("Etage: " + etage);
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
	        result = this.mere.getConnectionBD().GetAllLogements();

	        while (result.next()) {
	            Object[] row = new Object[10]; // Change the size as needed
	            row[0] = result.getInt("ID_LOGEMENT");
	            row[1] = result.getString("ETAGE");
	            row[2] = result.getString("TYPE");
	            row[3] = result.getString("SURFACE");
	            row[4] = result.getString("ICC");
	            row[5] = result.getString("GARAGE");
	            row[6] = result.getString("JARDIN");
	            row[7] = result.getString("BALCON");
	            row[8] = result.getString("state");
	            /*row[8] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getString(1));*/
	            row[9] = null;
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