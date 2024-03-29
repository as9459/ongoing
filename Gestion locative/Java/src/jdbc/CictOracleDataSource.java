package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JTextField;

import java.sql.ResultSetMetaData;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;
import oracle.sql.ARRAY;

public class CictOracleDataSource extends OracleDataSource {

    private Connection connection;
    private Statement statement;
    private PreparedStatement prepareStatement;
    private ResultSet result;

    public CictOracleDataSource() throws SQLException {
    	
        this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr" + ":1521:etupre");
    }
    


    /*------------- jbcd -------------*/
    
    
    public String creerAcces(String nom, String mdp) throws SQLException {
    	
		try {
	        this.setUser(nom);
	        this.setPassword(mdp);
			this.connection = this.getConnection();
			return "Connexion etablie";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e2.printStackTrace();
			return ""+e.getLocalizedMessage();
		}
    }
    
   
    
    public Statement createStatement() throws SQLException {
        this.statement = this.connection.createStatement();
        return this.statement;
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        this.prepareStatement = this.connection.prepareStatement(query);
        return this.prepareStatement;
    }

    public ResultSet executeQuery(String... query) throws SQLException {
        if (query.length == 0) {
            this.result = this.prepareStatement.executeQuery();
        } else {
            this.createStatement();
            this.result = this.statement.executeQuery(query[0]);
        }
        return this.result;
    }

    public ResultSet getResult () {
		return this.result;
	}

    public void afficheResult(ResultSet... resultSet) throws SQLException {
    	
    	if(resultSet.length == 0) {
	        if (this.result != null && !this.result.isClosed()) {
	            ResultSetMetaData metaData = this.result.getMetaData();
	            int columnCount = metaData.getColumnCount();
	
	            // Print column names
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.printf("%-20s", metaData.getColumnName(i));
	            }
	            System.out.println();
	
	            // Print rows
	            while (this.result.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    System.out.printf("%-20s", this.result.getString(i));
	                }
	                System.out.println();
	            }
	
	        } else if (this.result == null) {
	            System.out.println("ResultSet is null.");
	        } else {
	            System.out.println("ResultSet is closed.");
	        }
    	}else {
    		 if (resultSet[0] != null && !resultSet[0] .isClosed()) {
 	            ResultSetMetaData metaData = resultSet[0] .getMetaData();
 	            int columnCount = metaData.getColumnCount();
 	
 	            // Print column names
 	            for (int i = 1; i <= columnCount; i++) {
 	                System.out.printf("%-20s", metaData.getColumnName(i));
 	            }
 	            System.out.println();
 	
 	            // Print rows
 	            while (resultSet[0] .next()) {
 	                for (int i = 1; i <= columnCount; i++) {
 	                    System.out.printf("%-20s", resultSet[0] .getString(i));
 	                }
 	                System.out.println();
 	            }
 	
 	        } else if (resultSet[0]  == null) {
 	            System.out.println("ResultSet is null.");
 	        } else {
 	            System.out.println("ResultSet is closed.");
 	        }
    	}
    }
    
    public void close() {
        try {
            if (this.result != null) {
                this.result.close();
            }
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.prepareStatement != null) {
                this.prepareStatement.close();
            }
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    

    /*------------- general -------------*/

    public int callGetNextId(
    		String p_table_name,
    		String p_colom_id
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetNextId(?,?) }")) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, p_table_name);
            cs.setString(3, p_colom_id);
            cs.execute();
            return cs.getInt(1);
        }
    }

    public ResultSet callGetTableData(String tableName) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call getTableData(?) }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.setString(2, tableName);
            cs.execute();
            ResultSet originalResultSet = (ResultSet) cs.getObject(1);

            // Copy the data into a new ResultSet to avoid premature closure
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(originalResultSet);

            return rowSet;
        }
    }


    public void AddTypeCharges(
  	      	  String p_nom ,
    	      float p_prix_unitaire
    	   )throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call InsertTypeCharges(?,?) }")) {
            cs.setString(1, p_nom);
            cs.setFloat(2, p_prix_unitaire);
            cs.execute();
        }
    }

    public void AddEntreprise(
    	      String p_SIREN,
    	      String p_nom,
    	      String p_serves,
    	      String p_adresse,
    	      String p_code_postal,
    	      String p_IBAN,
    	      String p_ville,
    	      String p_e_mail,
    	      String p_telephone
    	   
    	   )throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call InsertEntreprise(?,?,?,?,?,?,?,?,?) }")) {
            cs.setString(1, p_SIREN);
            cs.setString(2, p_nom);
            cs.setString(3, p_serves);
            cs.setString(4, p_adresse);
            cs.setString(5, p_code_postal);
            cs.setString(6, p_IBAN);
            cs.setString(7, p_ville);
            cs.setString(8, p_e_mail);
            cs.setString(9, p_telephone);
            cs.execute();
        }
    }

    
    //InsertFicheDiagnostic
    //InsertCorrespondre
    
    public ArrayList<String> getTableData(String tableNom, String colonne) throws SQLException {
        ArrayList<String> result = new ArrayList<>();
        
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call getTableData(?, ?) ")){
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setString(2, tableNom);
                cs.setString(3, colonne);
                cs.execute();

                ResultSet resultSet = (ResultSet) cs.getObject(1);
	                while (resultSet.next()){
	                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
	                    	Object valeurColonne = resultSet.getObject(i);
	                        result.add(valeurColonne.toString());
	                    }
	                }
	            return result;
        }
    }
    

    /*------------- Locataire -------------*/

    public void callADDLocataire(
            int p_id_locataire,
            String p_nom,
            String p_prenom,
            String p_date_de_naissance,
            String p_telephone,
            String p_e_mail,
            String p_statut,
            int p_id_bail,
            String p_date_debut,
            String p_date_fin,
            float p_frais_d_agence,
            float p_loyer,
            float p_charges_fixes,
            float p_montant_aide,
            int p_jour_Paiement,
            int p_solod_TC,
            int p_id_batiment,
            int p_id_logement
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call AddLocataire(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
        	cs.setInt(1, p_id_locataire);
        	cs.setString(2,p_nom);
        	cs.setString(3,p_prenom);
        	cs.setString(4,p_date_de_naissance);
        	cs.setString(5,p_telephone);
        	cs.setString(6,p_e_mail);
        	cs.setString(7,p_statut);
        	cs.setInt(8,p_id_bail);
        	cs.setString(9,p_date_debut);
        	cs.setString(10,p_date_fin);
            cs.setFloat(11,p_frais_d_agence);
            cs.setFloat(12,p_loyer);
            cs.setFloat(13,p_charges_fixes);
            cs.setFloat(14,p_montant_aide);
            cs.setInt(15,p_jour_Paiement);
            cs.setInt(16, p_solod_TC);
            cs.setInt(17, p_id_batiment);
            cs.setInt(18, p_id_logement);
            cs.execute();
        }
    }


    public void callAddGarant(
    		int p_id_locataire,
            String p_nom,
            String p_adresse,
            String p_e_mail,
            String p_telephone
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call AddGarant(?,?,?,?,?) }")) {
            
            cs.setInt(1, p_id_locataire);
            cs.setString(2, p_nom);
            cs.setString(3, p_adresse);
            cs.setString(4, p_e_mail);
            cs.setString(5, p_telephone);
            cs.execute();
        }
    }

    
    public void callSetStatutEntree(
    	      int p_id_locataire,
    	      String p_statut_entree
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{all SetStatutEntree(?,?) }")) {
            cs.setInt(1, p_id_locataire);
            cs.setString(2, p_statut_entree);
            cs.execute();
        }
    }

    public void callSetStatutSorti(
    	      int p_id_locataire,
    	      int p_id_EDL,
    	      String p_statut_sortie
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{all SetStatutSorti(?,?) }")) {
            cs.setInt(1, p_id_locataire);
            cs.setString(3, p_statut_sortie);
            cs.execute();
        }
    }


    public int callGetLocateurIdByLogement(
    	    int p_id_batiment,
    	    int p_id_logement
    	    ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLocateurIdByLogement(?,?) }")) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, p_id_batiment);
            cs.setInt(3, p_id_logement);
            cs.execute();
            return cs.getInt(1);
        }
    }


    public String callGetLogementIdByLocateur1(
    	    int p_id_locataire
    	    ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLogementIdByLocateur(?) }")) {
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setInt(2, p_id_locataire);
            cs.execute();
            return cs.getString(1);
        }
    }

    public ResultSet callGetLocatairesActuels() throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLocatairesActuels() }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            ResultSet originalResultSet = (ResultSet) cs.getObject(1);

            // Copy the data into a new ResultSet to avoid premature closure
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(originalResultSet);

            return rowSet;
        }
    }
    
    public void AddLocataire(
  		  String p_nom,
  	      String p_prenom,
  	      String p_date_de_naissance,
  	      String p_telephone,
  	      String p_email,
  	      String p_statut
  	   )throws SQLException {
      try (CallableStatement cs = this.connection.prepareCall("{call InsertLocataire(?,?,?,?,?,?) }")) {
    	  cs.setString(1, p_nom);
          cs.setString(2, p_prenom);
          cs.setString(3, p_date_de_naissance);
          cs.setString(4, p_telephone);
          cs.setString(5, p_email);
          cs.setString(6, p_statut);
          //cs.execute();
          
          cs.execute();
        	    }
      catch (SQLException e) {
	        e.printStackTrace(); // Print the stack trace for debugging
	        throw e; // Rethrow the exception to the calling method
	    }
      }


    
    public void UpdateLocataire(
            String p_idLocataire,
            String p_nom,
            String p_prenom,
            String p_date_de_naissance,
            String p_telephone,
            String p_email,
            String p_statut
        ) throws SQLException {
            try (CallableStatement cs = this.connection.prepareCall("{call UpdateLocataire(?,?,?,?,?,?,?) }")) {
                cs.setString(1, p_idLocataire);
                cs.setString(2, p_nom);
                cs.setString(3, p_prenom);
                cs.setString(4, p_date_de_naissance);
                cs.setString(5, p_telephone);
                cs.setString(6, p_email);
                cs.setString(7, p_statut);
                cs.execute();
            }
        }
    
    public ArrayList<String> getNomPrenomLocataire(int idlocataire) throws SQLException {
        ArrayList<String> nomPrenomList = new ArrayList<>();
        
        try(CallableStatement cs = this.connection.prepareCall("{? = call GetNomPrenomLocataire(?)}")) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idlocataire);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    
                    nomPrenomList.add(nom);
                    nomPrenomList.add(prenom);
                }
            }
        }


        return nomPrenomList;
    }



    
    
    /*------------- Logement -------------*/

    public void AddLogement(
    		  int p_id_batiment,
    	      int p_id_logement,
    	      int p_etage,
    	      String p_type,
    	      float p_surface,
    	      float p_ICC,
    	      int p_colocation,
    	      int p_garage,
    	      int p_jardin,
    	      int p_balcon
    	   )throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call InsertLogement(?,?,?,?,?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_batiment);
            cs.setString(2, p_type);
            cs.setInt(3, p_etage);
            cs.setFloat(4, p_surface);
            cs.setFloat(5, p_ICC);
            cs.setInt(6, p_colocation);
            cs.setInt(7, p_garage);
            cs.setInt(8, p_jardin);
            cs.setInt(9, p_balcon);
            cs.setInt(10, p_id_logement);
            cs.execute();
        }
    }

    

    public boolean callIsLogementEmpty(
            int p_id_batiment,
            int p_id_logement,
            String p_date_debut_contrat
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call IsLogementEmpty(?,?,?) }")) {
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.setInt(2, p_id_batiment);
            cs.setInt(3, p_id_logement);
            cs.setString(3, p_date_debut_contrat);
            cs.execute();
            return cs.getBoolean(1);
        }
    }

    public ResultSet callGetLogementEmptys() throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLogementEmptys() }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            this.afficheResult((ResultSet) cs.getObject(1));
            return (ResultSet) cs.getObject(1);
        }
    }
    
    public int callGetNbLogByBatiment(int p_id_paiement ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetNbLogBatiment(?) }")) {
            cs.registerOutParameter(1, java.sql.Types.NUMERIC);
            cs.setInt(2, p_id_paiement);
            cs.execute();
            return cs.getInt(1);
        }
    }
    
    public String callGetLogementIdByLocateur(
            int p_id_locataire
            ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLogementIdByLocateur(?) }")) {
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setInt(2, p_id_locataire);
            cs.execute();
            return cs.getString(1);
        }
    }

    
    public void callAddLogementFacture(
    	    int p_id_facture,
    	    int p_id_batiment,
    	    int p_id_logement,
    	    String p_date_facture,
    	    String p_description,
    	    int p_aide,
    	    float p_montant_de_l_aide,
    	    float p_montant_HT,
    	    float p_TVA,
    	    String p_type,
    	    String p_SIREN,
    	    String p_reference_du_paiement,
    	    float p_paiement,
    	    String p_type_Paiment,
    	    String p_Date_de_paiement
    	    ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ call AddLogementFacture(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_facture);
            cs.setInt(2, p_id_batiment);
            cs.setInt(3, p_id_logement);
            cs.setString(4, p_date_facture);
            cs.setString(5, p_description);
            cs.setInt(6, p_aide);
            cs.setFloat(7, p_montant_de_l_aide);
            cs.setFloat(8, p_montant_HT);
            cs.setFloat(9, p_TVA);
            cs.setString(10, p_type);
            cs.setString(11, p_SIREN);
            cs.setString(12, p_reference_du_paiement);
            cs.setFloat(13, p_paiement);
            cs.setString(14, p_type_Paiment);
            cs.setString(15, p_Date_de_paiement);
            cs.execute();
        }
    }

    public void AddLogemontCharge(
    		int p_id_batiment,
            int p_id_logement,
    		int p_id_charges,
    		String p_date_charges,
    		int p_consommation,
    		int p_id_Type_Charges) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call AddLogemontCharge(?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_batiment);
            cs.setInt(2, p_id_logement);
            cs.setInt(3, p_id_charges);
            cs.setString(4, p_date_charges);
            cs.setInt(5, p_consommation);
            cs.setInt(6, p_id_Type_Charges);
            cs.execute();
        }
    }

    public void callSetLogementFacturePaiement(
    	    int p_id_facture,
    	    int p_id_batiment,
    	    int p_id_logement,
    	    String p_date_facture,
    	    String p_reference_du_paiement,
    	    float p_paiement,
    	    String p_type_Paiment,
    	    String p_Date_de_paiement
    	    )  throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ call SetLogementFacturePaiement(?,?,?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_facture);
            cs.setInt(2, p_id_batiment);
            cs.setInt(3, p_id_logement);
            cs.setString(4, p_date_facture);
            cs.setString(5, p_reference_du_paiement);
            cs.setFloat(6, p_paiement);
            cs.setString(7, p_type_Paiment);
            cs.setString(8, p_Date_de_paiement);
            cs.execute();
        }
    }
    
    public ResultSet callGetLogementUnpaidFacts() throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLogementUnpaidFacts() }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            this.afficheResult((ResultSet) cs.getObject(1));
            return (ResultSet) cs.getObject(1);
        }
    }
    


    
    /*------------- Batiment -------------*/

    
    public void AddBatiment(
    		  String p_id_batiment,
    	      String p_adresse,
    	      int p_code_postal,
    	      String p_ville,
    	      String p_regime_juridique,
    	      String p_date_construction
    	   
    	   )throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call InsertBatiment(?,?,?,?,?,?) }")) {
            
            cs.setString(1, p_adresse);
            cs.setInt(2, p_code_postal);
            cs.setString(3, p_ville);
            cs.setString(4, p_regime_juridique);
            cs.setString(5, p_date_construction);
            cs.setString(6, p_id_batiment);
            cs.execute();
        }
    }

    
   
    public void callAddBatimentFacture(
    	    int p_id_facture,
    	    int p_id_batiment,
    	    String p_date_facture,
    	    String p_description,
    	    int p_aide,
    	    float p_montant_de_l_aide,
    	    float p_montant_HT,
    	    float p_TVA,
    	    String p_type,
    	    String p_SIREN,
    	    String p_reference_du_paiement,
    	    float p_paiement,
    	    String p_type_Paiment,
    	    String p_Date_de_paiement
    	    ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ call AddBatimentFacture(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_facture);
            cs.setInt(2, p_id_batiment);
            cs.setString(3, p_date_facture);
            cs.setString(4, p_description);
            cs.setInt(5, p_aide);
            cs.setFloat(6, p_montant_de_l_aide);
            cs.setFloat(7, p_montant_HT);
            cs.setFloat(8, p_TVA);
            cs.setString(9, p_type);
            cs.setString(10, p_SIREN);
            cs.setString(11, p_reference_du_paiement);
            cs.setFloat(12, p_paiement);
            cs.setString(13, p_type_Paiment);
            cs.setString(14, p_Date_de_paiement);
            cs.execute();
        }
    }

    public void callAddBatimentCharge(
    		int p_id_batiment,
    		int p_id_charges,
    		String p_date_charges,
    		int p_consommation,
    		int p_id_Type_Charges) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call AddBatimentCharge(?,?,?,?,?) }")) {
            cs.setInt(1, p_id_batiment);
            cs.setInt(2, p_id_charges);
            cs.setString(3, p_date_charges);
            cs.setInt(4, p_consommation);
            cs.setInt(5, p_id_Type_Charges);
            cs.execute();
        }
    }

    public void callSetBatimentFacturePaiement(
    	    int p_id_facture,
    	    int p_id_batiment,
    	    String p_date_facture,
    	    String p_reference_du_paiement,
    	    float p_paiement,
    	    String p_type_Paiment,
    	    String p_Date_de_paiement
    	    )  throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ call SetBatimentFacturePaiement(?,?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_facture);
            cs.setInt(2, p_id_batiment);
            cs.setString(3, p_date_facture);
            cs.setString(4, p_reference_du_paiement);
            cs.setFloat(5, p_paiement);
            cs.setString(6, p_type_Paiment);
            cs.setString(7, p_Date_de_paiement);
            cs.execute();
        }
    }

    public ResultSet callGetBatimentUnpaidFacts() throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetBatimentUnpaidFacts() }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            this.afficheResult((ResultSet) cs.getObject(1));
            return (ResultSet) cs.getObject(1);
        }
    }
    /*
    public boolean deleteBatimentById(int idBatiment) {
        // Step 1: Identify and delete or update related records in LOGEMENT table
        handleRelatedLogementRecords(idBatiment);

        // Step 2: Delete the BATIMENT record
        String batimentSql = "DELETE FROM BATIMENT WHERE ID_BATIMENT = ?";

        try (PreparedStatement batimentStatement = this.prepareStatement(batimentSql)) {
            // Set the ID_BATIMENT parameter for BATIMENT deletion
            batimentStatement.setInt(1, idBatiment);

            // Execute the BATIMENT delete statement
            int batimentRowsAffected = batimentStatement.executeUpdate();

            // Check if any BATIMENT rows were affected
            return batimentRowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to handle related records in LOGEMENT table
    private void handleRelatedLogementRecords(int idBatiment) {
        // Step 3: Delete records from LOGEMENT table where ID_BATIMENT = idBatiment
        String logementSql = "DELETE FROM LOGEMENT WHERE ID_BATIMENT = ?";

        try (PreparedStatement logementStatement = this.prepareStatement(logementSql)) {
            // Set the ID_BATIMENT parameter for LOGEMENT deletion
            logementStatement.setInt(1, idBatiment);

            // Execute the LOGEMENT delete statement
            logementStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
    } 
    */
    

    
    public ResultSet GetAllLogements () throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetAllLogements () }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            ResultSet originalResultSet = (ResultSet) cs.getObject(1);

            // Copy the data into a new ResultSet to avoid premature closure
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(originalResultSet);

            return rowSet;
        }
    }
    
    public String getAdresseBatiment(int idBatiment) throws SQLException {
        String adresse = null;

        try (CallableStatement cs = this.connection.prepareCall("{? = call GETADRESSEBATIMENT(?)}")) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idBatiment);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                if (rs.next()) {
                    adresse = rs.getString("ADRESSE");
                }
            }
        }

        return adresse;
    }

    
    /*------------- Paiement -------------*/
    
    public void AddPaiement(
  		  int p_id_facture,
    	  int p_id_batiment,
  	      int p_id_logement,
  	      String p_reference_du_paiement,
  	      float p_paiement,
  	      String p_type_paiement,
  	      String p_date_de_paiement,
  	      int p_id_locataire
  	   )throws SQLException {
      try (CallableStatement cs = this.connection.prepareCall("{call INSERTPAIEMENT(?,?,?,?,?,?,?,?) }")) {
    	  cs.setInt(1, p_id_facture);
          cs.setInt(2, p_id_batiment);
          cs.setInt(3, p_id_logement);
          cs.setString(4, p_reference_du_paiement);
          cs.setFloat(5, p_paiement);
          cs.setString(6, p_type_paiement);
          cs.setString(7, p_date_de_paiement);
          cs.setInt(8, p_id_locataire);
          cs.execute();
      }
    }
    
    /*------------- Facture -------------*/
    
    public void AddFacture(
    	  int p_id_facture,
    	  String p_date_facture,
  	      String p_description,
  	      float p_montantHT,
  	      float p_tva,
  	      String p_type,
  	      int p_siren
  	   )throws SQLException {
      try (CallableStatement cs = this.connection.prepareCall("{call INSERTFACTURE(?,?,?,?,?,?,?) }")) {
    	  cs.setInt(1, p_id_facture);
          cs.setString(2, p_date_facture);
          cs.setString(3, p_description);
          cs.setFloat(4, p_montantHT);
          cs.setFloat(5, p_tva);
          cs.setString(6, p_type);
          cs.setInt(7, p_siren);
          cs.execute();
      }
    }
}
