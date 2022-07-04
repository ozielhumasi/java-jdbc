package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedStatement {
	
	public static final String url = "jdbc:mysql://localhost/TUTORIALSPOINT";
	public static final String user = "root";
	public static final String password = "calebinho29";
	public static final String sql = "UPDATE Employees SET age=? WHERE id=?";

	public static void main(String[] args) throws SQLException {
		
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			Integer idade = 99;
			Integer identificador = 103;
			
			pst.setInt(1, idade);
			pst.setInt(2, identificador);
			pst.execute();			
			
			ResultSet rs = pst.executeQuery("SELECT * FROM Employees");
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Age: " + rs.getInt(2));
				System.out.println("First name: " + rs.getString(3));
				System.out.println("Last name: " + rs.getString(4) + "\n");
			}
			
			conn.close();
			pst.close();
			rs.close();
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

