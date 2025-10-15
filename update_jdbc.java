      package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update_jdbc {

	public static void main(String[] args) {
				// Driver class
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver class not found");
				}
				
				// Connection
				
				Connection cn = null;
				
				try {
					cn = DriverManager.getConnection("jdbc:mysql://localhost/assignment", "root","");
				} catch (SQLException e) {
					System.out.println("Connection not found!");
				}
				
				// Data update
				
				String update = "update assignment1 set contact = ?, stu_name = ? , course = ? where id =?";
				
				try {
					PreparedStatement ps = cn.prepareStatement(update);
					
					ps.setInt(1,737738892);
					ps.setString(2,"jasavant" );
					ps.setString(3, "biology");
					ps.setInt(4,1);
					
					int a = ps.executeUpdate();
					
					if (a>0)
					{
						System.out.println("data update" + "("+ a + ")!");
					}
				} 
				catch (SQLException e) {
					System.out.println("Data not update!");
				}

	}

}
