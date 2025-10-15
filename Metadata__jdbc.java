package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Metadata__jdbc {

	public static void main(String[] args) {
		
				// Driver class
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver not found!");
					}
				
				// Connection java-DB
				Connection cn = null;
				
				try {
					cn = DriverManager.getConnection("jdbc:mysql://localhost/assignment", "root", "");
				
				} catch (SQLException e) {
					System.out.println("Connection not found!");
				}
				
				try {
					DatabaseMetaData metadata = cn.getMetaData();
					System.out.println("Database Name : "+ metadata.getDatabaseProductName());
					System.out.println("Database Version : "+ metadata.getDatabaseProductVersion());
					System.out.println("Database DriverName : "+ metadata.getDriverName());
					System.out.println("Database DriverVersion : "+ metadata.getDriverVersion());
					System.out.println("Database URL : "+metadata.getURL());
					System.out.println("Database Username : "+ metadata.getUserName());
					System.out.println("Database class : "+metadata.getClass());
					System.out.println("Database sqlKeyWords : "+ metadata.getSQLKeywords());
				} catch (SQLException e) {
						System.out.println("Data not get from metadata!");
				}


	}

}
