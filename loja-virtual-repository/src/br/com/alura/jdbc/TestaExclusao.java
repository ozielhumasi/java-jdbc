package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaExclusao {
	
	public static void main(String[] args) throws SQLException {
				
		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.recuperaConexao();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasApagadas = stm.getUpdateCount();
		System.out.println("A quantidade de linhas "
				+ "apagadas foi: " + linhasApagadas);
		
	}

}
