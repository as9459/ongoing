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
import Vue.FenCharges;

public class GestionFenCharges implements ActionListener{
	private FenCharges fene;
	private FenetrePrincipale mere;
	private static ArrayList<String> idvalues;
	//private DefaultTableModel modeleTable;

	public GestionFenCharges(FenCharges fen, FenetrePrincipale mere) {
		this.fene = fen;
		this.mere = mere;
	

	@Override
	public void actionPerformed(ActionEvent e) {
        JButton bouton =(JButton) e.getSource();
        
    	switch(bouton.getText()) {
  
    	case "Retour":
    		fene.dispose();
    		break;
    	case "Valider":
    		double waterFixCost = Double.valueOf((String)GetData(table, 0, 1));
        	double garbageFixCost = Double.valueOf((String)GetData(table, 1, 1));
        	double electricityFixCost = Double.valueOf((String)GetData(table, 2, 1));
        	double waterQuotité = Double.valueOf((String)GetData(table, 0, 2));
        	double garbageQuotité = Double.valueOf((String)GetData(table, 1, 2));
        	double electricityQuotité = Double.valueOf((String)GetData(table, 2, 2));
        	double months = Double.valueOf((String)GetData(table, 0, 3));
        	
        	double waterOldIndex = Double.valueOf((String)GetData(table, 0, 4));
        	double waterNewIndex = Double.valueOf((String)GetData(table, 0, 5));
        	
        	double waterVolume = Double.valueOf(waterNewIndex - waterOldIndex);
        	double waterPrixUnitaire = Double.valueOf((String)GetData(table, 0, 7));
        	double waterCost = Double.valueOf(waterFixCost * waterQuotité/ 100.0 * (months/12) + waterVolume * waterPrixUnitaire);
        	double garbageCost = Double.valueOf(garbageFixCost *garbageQuotité/100 * (months/12));
        	double electricityCost = (electricityFixCost * electricityQuotité/100.0 * (months/12));
        	double Total = Double.valueOf(waterCost + garbageCost + electricityCost);
        	table.setValueAt(decfor.format(waterVolume), 0, 6);
        	table.setValueAt(decfor.format(waterCost), 0, 8);
        	table.setValueAt(decfor.format(garbageCost), 1, 8);
        	table.setValueAt(decfor.format(electricityCost), 2, 8);
        	table.setValueAt(decfor.format(Total), 3, 8);
			
            break;
			
		default:
			break;
    	}
	}
    	

	public static ArrayList<String> getIdvalues() {
		return idvalues;
	}

	

}
