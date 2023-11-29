package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*import modele.Creneau;
import modele.Groupe;
import modele.dao.DaoCreneau;
import modele.dao.DaoGroupe;*/
import Vue.SaisirPaiement;

public class GestionSaisirPaiement implements ActionListener{

	private SaisirPaiement sb;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirPaiement(SaisirPaiement sb) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sb = sb;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Insérer":
				this.sb.dispose();
				break;
			case "Annuler":
				this.sb.dispose();
				break;
			default:
				break;
		}
	}

}
