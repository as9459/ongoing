package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.FenBatiment;
import Vue.FenEntreprise;
import Vue.FenetrePrincipale;
import Vue.SaisirBatiment;
import Vue.SaisirEntreprise;
import jdbc.CictOracleDataSource;

public class GestionSaisirEntreprise implements ActionListener{

	private SaisirEntreprise sb;
	private FenetrePrincipale mere;
	private FenEntreprise fenee;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirEntreprise(SaisirEntreprise sb, FenetrePrincipale mere, FenEntreprise fenee){ /*(SaisirBatiment sc, JTable tableC)*/
		this.sb = sb;
		this.mere = mere;
		this.fenee = fenee;
		
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Inserer":
				break;
				
			case "Annuler":
				this.sb.dispose();
				break;
			default:
				break;
		}
	}

}

