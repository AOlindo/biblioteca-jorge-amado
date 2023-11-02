package br.com.bibliotecaJorgeAmado.Dto;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Autor;

public class ListagemAutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public ListagemAutorDTO() {

	}

	public ListagemAutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();

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
