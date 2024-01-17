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
import javax.swing.JMenuItem;
import javax.swing.JTable;

import ES.QuittancePdf;
import modele.Charges;
import Vue.Connexion;
import Vue.FenetrePrincipale;
import Vue.SaisirFacture;
import Vue.SaisirPaiement;
import Vue.FenLocataire;
import Vue.FenLogement;
import Vue.FenPaiement;

public class GestionFenPaiement implements ActionListener{
	private FenPaiement fene;
	private FenetrePrincipale mere;
	private String idfacture;
	private String idbatiment;
	private String idlogement;
	private String idlocataire;
    private String date;
    private String refpaiement;
    private String type;
    private String paiement;

	public GestionFenPaiement(FenPaiement fen, FenetrePrincipale mere) {
		this.fene = fen;
		this.mere = mere;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FenetrePrincipale fen = (FenetrePrincipale) fene.getTopLevelAncestor();
        JButton bouton =(JButton) e.getSource();
        
        if (fene != null) {
            JTable myTable = fene.getTablePaiement();
            int selectedRow = myTable.getSelectedRow();
        
	    	switch(bouton.getText()) {
	  
		    	case "Retourner":
		    		fene.dispose();
		    		break;
		    	case "Ajouter":
					SaisirPaiement sbat = null;
					try {
						sbat = new SaisirPaiement(this.mere, this.fene);
						JLayeredPane layeredPane4 = fen.getLayeredPane();
						layeredPane4.add(sbat, JLayeredPane.DEFAULT_LAYER);
						sbat.setVisible(true);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		            break;
		    	case "Modifier":
		    		if (selectedRow != -1) {
		                 this.idfacture = myTable.getValueAt(selectedRow, 0).toString();
		                 this.idbatiment = myTable.getValueAt(selectedRow, 1).toString();
		                 this.idlogement = myTable.getValueAt(selectedRow, 2).toString();
		                 this.idlocataire = myTable.getValueAt(selectedRow, 3).toString();
		                 this.refpaiement = myTable.getValueAt(selectedRow, 4).toString();
		                 this.paiement = myTable.getValueAt(selectedRow, 5).toString();
		                 this.type = myTable.getValueAt(selectedRow, 6).toString();
		                 this.date = myTable.getValueAt(selectedRow, 7).toString();
		                 
		                 
			            try {
				            SaisirPaiement mfac = new SaisirPaiement(this.mere, this.fene);
				            mfac.loadPaiementInfo(idfacture, idbatiment, idlogement, idlocataire, refpaiement, paiement, type, date);
							JLayeredPane layeredPane5 = this.mere.getLayeredPane();
							layeredPane5.add(mfac, JLayeredPane.DEFAULT_LAYER);
							mfac.setVisible(true);
			            } 
			            catch (ParseException e1) {
			            	e1.printStackTrace();
			            }
		            }
		    		break; 
		    	case "Imprimer Quittance":
		    		if (selectedRow != -1) { 
		    	        
		    	        
		    	        try {
		    	        	String idFacture = myTable.getValueAt(selectedRow, 0).toString();
			    	        int idBatiment = (int) myTable.getValueAt(selectedRow, 1);
			    	        int idLocataire = (int) myTable.getValueAt(selectedRow, 3);
			    	        String refPaiement = myTable.getValueAt(selectedRow, 4).toString();
			    	        String datePaiement = myTable.getValueAt(selectedRow, 7).toString();
			    	        String typePaiement = myTable.getValueAt(selectedRow, 6).toString();
			    	        String loyerPaiement = myTable.getValueAt(selectedRow, 5).toString();
			    	        /*String provision = myTable.getValueAt(selectedRow, 8).toString();*/
			    	        
							ArrayList<String> NomPrenom = this.mere.getConnectionBD().getNomPrenomLocataire(idLocataire);
							String nomLocataire = NomPrenom.get(0);
							String prenomLocataire = NomPrenom.get(1);
							
							String adresseLocataire = this.mere.getConnectionBD().getAdresseBatiment(idBatiment);
							
							QuittancePdf maQuittance = new QuittancePdf(this);
							maQuittance.imprimerQuittance(nomLocataire, prenomLocataire, adresseLocataire, datePaiement, refPaiement, typePaiement, loyerPaiement); 
							
							System.out.println("check");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
		    	        
		    	        
		    	    }
		    		break;
	    		}
          }	
	}
    
	
	
	/*public String getQidfacture() {
		return this.idfacture;
	}
	
	public String getQdate() {
		return this.date;
	}
	
	public String getQrefpaiement() {
		return this.refpaiement;
	}
	
	public String getQtype() {
		return this.type;
	}
	
	public String getQpaiement() {
		return this.paiement;
	}*/
	
	public Object[][] updateTable() {
	    ResultSet result = null;
	    List<Object[]> dataList = new ArrayList<>();

	    try {
	        result = this.mere.getConnectionBD().callGetTableData("FACT_LOGEMENT");

	        while (result.next()) {
	            Object[] row = new Object[9]; // Change the size as needed
	            row[0] = result.getInt("ID_FACTURE");
	            row[1] = result.getInt("ID_BATIMENT");
	            row[2] = result.getString("ID_LOGEMENT");
	            row[3] = result.getInt("ID_LOCATAIRE");
	            row[4] = result.getString("REFERENCE_DU_PAIEMENT");
	            row[5] = result.getString("LOYER");
	            row[6] = result.getString("TYPE_PAIMENT");
	            row[7] = result.getString("DATE_DE_PAIEMENT");
	            row[8] = result.getString("PROVISION");
	            /*row[8] = this.mere.getConnectionBD().callGetNbLogByBatiment(result.getString(1));*/
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