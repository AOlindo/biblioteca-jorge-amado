package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAutorDTO;
import br.com.bibliotecaJorgeAmado.Dto.AutorDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroAutorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;

@Entity
public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	

	public Autor() {
		
	}
	public Autor(CadastroAutorDTO autor) {
		this.nome = autor.getNome();
	}
	public void atualizaAutor(@Valid AtualizarAutorDTO atualizaDto) {
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


}
