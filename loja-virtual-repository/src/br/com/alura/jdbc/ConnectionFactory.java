package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;

	public ConnectionFactory() {

		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("calebinho29");
		
		cpds.setMaxPoolSize(15);
		
		this.dataSource = cpds;
	}

	public Connection recuperaConexao() throws SQLException {

//		Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "calebinho29");
//		return con;
		return this.dataSource.getConnection();
		
	}

}
