package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAutorDto;
import br.com.bibliotecaJorgeAmado.Dto.AtualizarEditoraDto;
import br.com.bibliotecaJorgeAmado.Dto.AutorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

@Entity
public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany
	private List<Livro> livro = new ArrayList<>();
	
	public Autor() {
		
	}
	public Autor(AutorDto autorDto) {
		this.nome = autorDto.getNome();
	}
	public void atualizaAutor(@Valid AtualizarAutorDto atualizaDto) {
		if (atualizaDto.getNome() != null) {
			this.nome = atualizaDto.getNome();
		}
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

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}
	
	
	
	
}
