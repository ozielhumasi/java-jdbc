package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstExample {
	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASS = "calebinho29";
	static final String QUERY = "SELECT id, first, last, age FROM Employees";

	public static void main(String[] args) throws SQLException {

		// OPEN A CONNECTION
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			// EXTRACT DATA FROM RESULTSET
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Age: " + rs.getInt("age"));
				System.out.println("First name: " + rs.getString("first"));
				System.out.println("Last name: " + rs.getString("last"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
