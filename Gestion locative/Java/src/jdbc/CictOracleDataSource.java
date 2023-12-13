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

import java.sql.ResultSetMetaData;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

public class CictOracleDataSource extends OracleDataSource {

    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement prepareStatement;
    protected ResultSet result;

    public CictOracleDataSource() throws SQLException {
		super();
        this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr" + ":1521:etupre");
        
    }
    

    
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

    

}
