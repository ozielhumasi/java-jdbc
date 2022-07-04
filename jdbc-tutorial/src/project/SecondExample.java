package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SecondExample {
	
	public static final String url = "jdbc:mysql://localhost/TUTORIALSPOINT";
	public static final String user = "root";
	public static final String password = "calebinho29";
	public static final String sql = "UPDATE Employees SET age=55 WHERE id=100";

	public static void main(String[] args) throws SQLException {
		
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			
			Statement st = conn.createStatement();
			boolean resultado = st.execute(sql);
			System.out.println("O método chamado retorna um ResultSet : " + resultado);
			
			ResultSet rs = st.executeQuery("SELECT * FROM Employees");
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Age: " + rs.getInt(2));
				System.out.println("First name: " + rs.getString(3));
				System.out.println("Last name: " + rs.getString(4));		
			}
			
			conn.close();
			st.close();
			rs.close();
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

