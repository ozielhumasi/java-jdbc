package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class TestaListagemDeCategorias {
	
	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			
			List<Categoria> listaDeCategorias = categoriaDao.listar();
			listaDeCategorias.stream().forEach(lc -> System.out.println(lc.getNome()));
			
			
			
		}
		
		
//		try(Connection conn = new ConnectionFactory().recuperaConexao()){
//			
//			// ESSA CLASSE DEVE ME RETORNAR AS CATEGORIAS EXISTENTES;
//			System.out.println("Conexão bem sucedida!");
//			String sql = "SELECT * FROM CATEGORIA";
//			
//			PreparedStatement pstm = conn.prepareStatement(sql);
//			pstm.execute();
//			
//			ResultSet rst = pstm.getResultSet();
//			
//			while(rst.next()) {
//				System.out.println(rst.getString(2));
//			}
//			
//			
//		}
	}

}
