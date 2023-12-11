package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	private SaisirLogement s1;
	/*private DefaultTableModel modeleTable;
	private DaoGroupe daoGroupe;*/
	
	public GestionSaisirLogement(SaisirLogement s1) { /*(SaisirBatiment sc, JTable tableC)*/
		this.s1 = s1;
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
				
				int nbBatiment = s1.getTextFieldNbBatement();
                int nbLogement = s1.getTextFieldNbLogement();
                int etage = s1.getTextFieldEtage();
                String typeLogement = s1.getTextFieldTypeLogement();
                float surface = s1.getTextFieldSurface();
                float icc = s1.getTextFieldICC();
                int garage = s1.getTextFieldGarage();
                int jardin = s1.getTextFieldJardin();
                int balcon = s1.getTextFieldBalcon();
                
			CictOracleDataSource cictOracleDataSource;
			try {
				cictOracleDataSource = new CictOracleDataSource();
                cictOracleDataSource.AddLogement(0, nbLogement,etage, typeLogement, surface,icc, garage, jardin, balcon);
                
                

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}                								 
                								 
				
				this.s1.dispose();
				
				break;
			case "Annuler":
				this.s1.dispose();
				break;
			default:
				break;
		}
	}

}
