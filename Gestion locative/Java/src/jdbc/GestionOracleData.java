package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.ResultSetMetaData;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

public class GestionOracleData extends CictOracleDataSource {


    private GestionBatiment gestionBatiment;
    private GestionLocataire gestionLocataire;
    private GestionLogement gestionLogement;

    public GestionOracleData() throws SQLException {
		super();
    }

    


    public GestionLogement logement() {
        if (gestionLogement == null) {
            try {
                gestionLogement = new GestionLogement(this.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gestionLogement;
    }

    
    public GestionBatiment batiment( ) {
        if (gestionBatiment == null) {
            try {
                gestionBatiment = new GestionBatiment(this.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gestionBatiment;
    }

    
    public GestionLocataire locataire( ) {
        if (gestionLocataire == null) {
            try {
            	gestionLocataire = new GestionLocataire(this.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gestionLocataire;
    }



    /*------------- general -------------*/

    public int getNextId(
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
    
    
    public ResultSet getTableData(String tableName, String... col) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call getTableData(?, ?) }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.setString(2, tableName);
            
            // Convert the array of column names to a comma-separated string
            String columnNames = (col != null && col.length > 0) ? "DISTINCT " + String.join(",", col) : null;
            cs.setString(3, columnNames);
            
            cs.execute();
            ResultSet originalResultSet = (ResultSet) cs.getObject(1);

            // Copy the data into a new ResultSet to avoid premature closure
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(originalResultSet);

            return rowSet;
        }
    }



    public void addTypeCharges(
  	      	  String p_nom ,
    	      float p_prix_unitaire
    	   )throws SQLException {
        try (CallableStatement cs = super.connection.prepareCall("{call InsertTypeCharges(?,?) }")) {
            cs.setString(1, p_nom);
            cs.setFloat(2, p_prix_unitaire);
            cs.execute();
        }
    }

    
    public void addEntreprise(
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
    
}