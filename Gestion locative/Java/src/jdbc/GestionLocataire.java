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

public class GestionLocataire extends CictOracleDataSource {


    public GestionLocataire(Connection connection2) throws SQLException {
		super();
        this.connection = connection2;
	}
    
    public ResultSet getLocatairesActuels() throws SQLException {
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
    public int getIdByLogement(
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


    public void add(
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


    public void addGarant(
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

    
    public void setStatutEntree(
    	      int p_id_locataire,
    	      String p_statut_entree
        ) throws SQLException {
        try (CallableStatement cs = this.connection.prepareCall("{all SetStatutEntree(?,?) }")) {
            cs.setInt(1, p_id_locataire);
            cs.setString(2, p_statut_entree);
            cs.execute();
        }
    }

    
    public void setStatutSorti(
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


   }

    