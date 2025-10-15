package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_jdbc {

	public static void main(String[] args) {
				//driver class
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver not found!");
					}
				
				//connection  java-DB
				Connection cn = null;
				
				try {
					cn = DriverManager.getConnection("jdbc:mysql://localhost/assignment", "root", "");
				} catch (SQLException e) {
					System.out.println("Connection not found!");
				}
				
				//data delete
				String delete = "delete from assignment1 where id = ?";
				
				try {
					PreparedStatement ps = cn.prepareStatement(delete);
					
					ps.setInt(1,2);
					
					int a = ps.executeUpdate();
					
					if (a>0) {
						System.out.println("deleted row"+ "("+ a + ")!");
					}
					
				} catch (SQLException e) {
					System.out.println("Data not delete!");
				}

	}

}
