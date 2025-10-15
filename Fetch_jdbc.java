package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch_jdbc {

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
		
		// Fetch
		String fetch = "select * from assignment1";
		
		try {
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(fetch);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getInt(2)+" : "+rs.getString(3)+" : "+rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Data not Fetch!");
		}
	}

}
