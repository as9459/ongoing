package jdbc;

import java.sql.*;

import javax.sql.DataSource;

public class main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	    {
	        String url = "jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre";
	        String username = "LHB3409A";
	        String password = "Ps1052";

	        
	        CictOracleDataSource bd = new CictOracleDataSource(username,password);
	        
	        
	        

            System.out.printf("id : "+ bd.callGetNextId("Locataire", "id_locataire"));
	        bd.close();
	    }
	} 


