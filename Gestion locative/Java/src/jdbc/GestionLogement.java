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

public class GestionLogement extends CictOracleDataSource {

    private Connection connection;
    private Statement statement;
    private PreparedStatement prepareStatement;
    private ResultSet result;

    public GestionLogement() throws SQLException {
		super();
	}
    

    

    public boolean callIsLogementEmpty(
            int p_id_batiment,
            int p_id_logement,
            String p_date_debut_contrat
        ) throws SQLException {
        try (CallableStatement cs = super.connection.prepareCall("{ ? = call IsLogementEmpty(?,?,?) }")) {
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.setInt(2, p_id_batiment);
            cs.setInt(3, p_id_logement);
            cs.setString(3, p_date_debut_contrat);
            cs.execute();
            return cs.getBoolean(1);
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

    

    public void AddLogement(
    		  int p_id_batiment,
    	      int p_id_logement,
    	      String p_type,
    	      int p_etage,
    	      float p_surface,
    	      int p_colocation,
    	      int p_ICC,
    	      int p_garage,
    	      int p_jardin,
    	      int p_balcon
    	   )throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{call InsertLogement(?,?,?,?,?,?,?,?,?,?) }")) {
            cs.setInt(1, p_id_batiment);
            cs.setString(2, p_type);
            cs.setInt(3, p_etage);
            cs.setFloat(4, p_surface);
            cs.setInt(5, p_ICC);
            cs.setInt(6, p_colocation);
            cs.setInt(7, p_garage);
            cs.setInt(8, p_jardin);
            cs.setInt(9, p_balcon);
            cs.setInt(10, p_id_logement);
            cs.execute();
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
    
    
    public ResultSet callGetLogementUnpaidFacts() throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{ ? = call GetLogementUnpaidFacts() }")) {
            cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            cs.execute();
            this.afficheResult((ResultSet) cs.getObject(1));
            return (ResultSet) cs.getObject(1);
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
    




}
