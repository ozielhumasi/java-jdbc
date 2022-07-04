package br.com.alura.jdbc.modelo;

public class Categoria {
	
	private Integer id;
	private String nome;
	
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

	
	
	
}
