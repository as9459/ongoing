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
	public void actionPerformed(ActionEvent e) {
		
		FenetrePrincipale fenlog = (FenetrePrincipale) log.getTopLevelAncestor();
		JButton botonn = (JButton) e.getSource();
		switch (botonn.getText()) {
			case "Retourner":
				log.dispose();
				break;
			case "Ajouter":
				SaisirLogement slog = new SaisirLogement();
				JLayeredPane layeredPane8 = fenlog.getLayeredPane();
				layeredPane8.add(slog, JLayeredPane.DEFAULT_LAYER);
				slog.setVisible(true);
	            break;
	            
	            
	    	case "Modifier":
				SaisirLogement mlog = null;
				mlog = new SaisirLogement();
				JLayeredPane layeredPane5 = this.mere.getLayeredPane();
				layeredPane5.add(mlog, JLayeredPane.DEFAULT_LAYER);
				mlog.setVisible(true);
	            break;
		}
	}
	
	
	public Object[][] updateTable() {
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().callGetTableData("LOGEMENT");

	        while (result.next()) {
	            Object[] row = new Object[10]; // Change the size as needed
	            row[0] = result.getString(2);
	            row[1] = result.getString(3);
	            row[2] = result.getString(4);
	            row[3] = result.getString(5);
	            row[4] = result.getString(6);
	            row[5] = result.getString(7);
	            row[6] = result.getString(8);
	            row[7] = result.getString(9);
	            row[8] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getInt(1));
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