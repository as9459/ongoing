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
import Vue.SaisirBatiment;

public class GestionSaisirBatiement implements ActionListener{

	private SaisirBatiment sb;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirBatiement(SaisirBatiment sb) { /*(SaisirBatiment sc, JTable tableC)*/
		this.sb = sb;
		/*this.modeleTable = (DefaultTableModel) tableC.getModel();
		this.daoGroupe = new DaoGroupe();		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
			case "Insérer":
				String p_id_batiment = sb.getFd_Adresse();
				AddBatiment(p_id_batiment,  String p_adresse, p_code_postal, p_ville, p_regime_juridique, p_date_construction);
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
