package Controleur;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modele.Batiment;
import modele.dao.DaoBatiment;
import Vue.FenBatiment;

public class GestionTabBatiment implements ListSelectionListener{

	private FenBatiment fenBatiment;
	private DaoBatiment daoBatiment;
	private String[] primaryKey;
	private int numeroLigne;
	
	public GestionTabBatiment(FenBatiment fenBatiment) {
		this.fenBatiment = fenBatiment;
		this.daoBatiment = new DaoBatiment();
		this.primaryKey = new String[7];
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e){
		// JTable jtable = (JTable) e.getSource();
		JTable jtable = fenBatiment.getTableBatiment();
		if (jtable.getSelectedRow() != -1) {
			this.numeroLigne = jtable.getSelectedRow();
			
			// Récupération des Ids du Batiment
			this.primaryKey[0] = (String) jtable.getValueAt(numeroLigne, 0);
			this.primaryKey[1] = (String) jtable.getValueAt(numeroLigne, 1);
			this.primaryKey[2] = (String) jtable.getValueAt(numeroLigne, 2);
			this.primaryKey[3] = (String) jtable.getValueAt(numeroLigne, 3);
			this.primaryKey[4] = (String) jtable.getValueAt(numeroLigne, 4);
			this.primaryKey[5] = (String) String.valueOf(jtable.getValueAt(numeroLigne, 5));
			this.primaryKey[6] = (String) String.valueOf(jtable.getValueAt(numeroLigne, 6));
			
			//Batiment cr = daoBatiment.findById(primaryKey);
		}
	}
}