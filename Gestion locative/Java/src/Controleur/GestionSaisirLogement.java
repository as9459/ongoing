package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.CictOracleDataSource;

/*import modele.Creneau;
import modele.Groupe;
import modele.dao.DaoCreneau;
import modele.dao.DaoGroupe;*/
import Vue.SaisirLogement;

public class GestionSaisirLogement implements ActionListener{

	private SaisirLogement sl;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirLogement(SaisirLogement sl) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sl = sl;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Insérer":
				
				// TODO
				/*Groupe groupe = daoGroupe.findById(this.sc.getTextFieldIdGrpC().getText());
				Creneau cr = new Creneau(this.sc.getTextFieldDebsemc().getText(),
										 this.sc.getTextFieldJourC().getText(), 
										 this.sc.getTextFieldHeureDC().getText(), 
										 this.sc.getTextFieldHeureFC().getText(), 
										 this.sc.getTextFieldTypeC().getText(), 
										 null,
										 groupe);
				new DaoCreneau().create(cr);
				modeleTable.addRow(new Object[] {
						cr.getDebsemc(), 
						cr.getJourc(),
						cr.getHeuredc(),
						cr.getHeurefc(),
						cr.getTypec(),
						cr.getGrpC().getGrpc()
				});;*/
				this.sl.dispose();
				//CictOracleDataSource.AddLogement(0, 0, sl.getTextFieldTypeLogement(), sl.getTextFieldLoyer(), sl.getTextFieldEtage(), sl.getTextFieldICC(), sl.getTextFieldGarage(), sl.getTextFieldJardin());
				break;
			case "Annuler":
				this.sl.dispose();
				break;
			default:
				break;
		}
	}

}
