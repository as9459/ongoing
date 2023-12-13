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

	private Connection connection;
    private Statement statement;
    private PreparedStatement prepareStatement;
    private ResultSet result;
    private GestionBatiment gestionBatiment;
    private GestionLocataire gestionLocataire;
    private GestionLogement gestionLogement;

    public GestionOracleData() throws SQLException {
		super();
        this.gestionBatiment = new GestionBatiment() ;
        this.gestionLocataire = new GestionLocataire();
        this.gestionLogement = new GestionLogement();
        
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
    
    public ResultSet callGetTableData(String tableName, String... col) throws SQLException {
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
    




    public GestionBatiment Batiment( ) {
    	return this.gestionBatiment;
    }

    public GestionLocataire Locataire( ) {
    	return this.gestionLocataire;
    }

    public GestionLogement Logement( ) {
    	return this.gestionLogement;
    }
}