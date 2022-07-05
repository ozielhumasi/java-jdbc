package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String categoria) {
		super();
		this.id = id;
		this.nome = categoria;
	}

	public Integer getId() {
		return this.id;
	}


	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return String.format("A categoria atual é: %d %s", this.id, this.nome);
	
	}

	public void adicionar(Produto produto) {
		this.produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	
	
	
}
