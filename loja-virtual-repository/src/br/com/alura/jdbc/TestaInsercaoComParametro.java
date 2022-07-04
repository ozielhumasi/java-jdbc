package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory cf = new ConnectionFactory();
		try (Connection connection = cf.recuperaConexao()) {

			/*
			 * Desabilitando o autoCommit, o controle da transação é passado para o
			 * developer. Só será comitado aquilo que ele deixar explícito que deve ser
			 * comitado.
			 */
			connection.setAutoCommit(false);
			
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT" + " INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("SMART TV", "45 POLEGADAS", stm);
				adicionarVariavel("RADIO", "RADIO DE BATERIA", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Roolback executado");
				// O rollback desfaz as alterações feitas no DB pela transação;
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("RADIO")) {
			throw new RuntimeException("Não foi possível adicionar o produto");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}

}
