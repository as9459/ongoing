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

public class GestionBatiment extends CictOracleDataSource {



    public GestionBatiment(Connection connection2) throws SQLException {
		super();
        this.connection = connection2;
	}
    
    
    public void add(
    	      String p_id_batiment,
    	      String p_adresse,
    	      String p_code_postal,
    	      String p_ville,
    	      String p_regime_juridique,
    	      String p_date_construction
    	   
    	   )throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call InsertBatiment(?,?,?,?,?,?) }")) {
            
            cs.setString(1, p_adresse);
            cs.setString(2, p_code_postal);
            cs.setString(3, p_ville);
            cs.setString(4, p_regime_juridique);
            cs.setString(5, p_date_construction);
            cs.setString(6, p_id_batiment);
            cs.execute();
        }
    }

   
    public void addFacture(
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

    
    public void addCharge(
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

    
    public ResultSet getUnpaidFacts() throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetBatimentUnpaidFacts() }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            this.afficheResult((ResultSet) cs.getObject(1));
            return (ResultSet) cs.getObject(1);
        }
    }

    
    public void setFacturePaiement(
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

    







}
