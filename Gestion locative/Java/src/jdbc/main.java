package 	jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class main {

	public static void main(String[] args) throws SQLException{
		
	        String username = "LHB3409A";
	        String password = "Ps1052";

	        
	        CictOracleDataSource bd = new CictOracleDataSource();
	        bd.creerAcces(username,password);
	        Connection cn = bd.getConnection();
	        
	        
        	String query = "SELECT DISTINCT ID_BATIMENT FROM BATIMENT";
        	PreparedStatement preparedStatement = cn.prepareStatement(query);
        	
        	ResultSet resultSet = preparedStatement.executeQuery();
            List<String> values = new ArrayList<>();

            while (resultSet.next()) {
                String value = resultSet.getString("ID_BATIMENT");
                values.add(value);
            }

            System.out.print("{");
            for (int i = 0; i < values.size(); i++) {
                System.out.print("\"" + values.get(i) + "\"");
                if (i < values.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");

            // Close resources (close the ResultSet, PreparedStatement, and Connection)
            resultSet.close();
            preparedStatement.close();
            cn.close();
        }
}



