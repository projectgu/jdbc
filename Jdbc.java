package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Driver class
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found!");
		}
		
		//Connectivity of Java-Jdbc
		
		Connection cn= null;
		
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost/assignment", "root", "");
			
			System.out.println("Connections Successful!");
			
		} catch (SQLException e) {
			System.out.println("Connection not found!");
		}
		
		//Data insert
		
		String Insert = "insert into assignment1 (contact,stu_name,course) values (?,?,?)";
		
		try {
			PreparedStatement ps = cn.prepareStatement(Insert);
			
			ps.setInt(1, 949903994);
			ps.setString(2, "mohan");
			ps.setString(3, "Venety");
			
			int a= ps.executeUpdate();
			
			if(a>0) {
				System.out.println("Inserted Row" + "("+ a + ")");
			}
			
		} catch (SQLException e) {
			System.out.println("Not Inserted Row");
		}
		
	}

}
