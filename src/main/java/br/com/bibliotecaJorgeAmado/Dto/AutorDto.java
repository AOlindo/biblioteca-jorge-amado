package br.com.bibliotecaJorgeAmado.Dto;

import br.com.bibliotecaJorgeAmado.domain.Autor;

public class AutorDTO {

	private Integer id;
	private String nome;
	
	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.id = autor.getId();
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
