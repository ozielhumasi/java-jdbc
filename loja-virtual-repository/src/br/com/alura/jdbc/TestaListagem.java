package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperaConexao();

		PreparedStatement stm = con.prepareStatement("SELECT id, nome, descricao FROM PRODUTO");
		/*
		 * O método Statement.execute("") retorna true quando o seu retorno for uma
		 * Lista.
		 */
		stm.execute();
		

		ResultSet set = stm.getResultSet();

		/*
		 * O método ResultSet.next() verifica se há um próximo item na tabela. Caso sim,
		 * retorna true.
		 */
		while (set.next()) {
			int id = set.getInt("id");
			System.out.println(id);
			String nome = set.getString("nome");
			System.out.println(nome);
			String descricao = set.getString(3);
			System.out.println(descricao);
		}

		System.out.println("Fechando conexão");
		con.close();
	}
}
