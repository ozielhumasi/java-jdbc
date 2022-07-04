package br.com.alura.jdbc;
import java.sql.SQLException;

public class TestaPoolDeConexoes {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			cf.recuperaConexao();
			System.out.println("Conexão de número: " + i);
		}
	}

}
