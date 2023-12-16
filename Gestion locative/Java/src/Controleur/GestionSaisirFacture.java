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
import Vue.SaisirFacture;

public class GestionSaisirFacture implements ActionListener{

	private SaisirFacture sf;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirFacture(SaisirFacture sf) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sf = sf;
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
				this.sf.dispose();
				break;
			case "Annuler":
				this.sf.dispose();
				break;
			default:
				break;
		}
	}

}
