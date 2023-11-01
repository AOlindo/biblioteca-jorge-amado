package br.com.bibliotecaJorgeAmado.Dto;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarEditoraDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroEditoraDTO;
import br.com.bibliotecaJorgeAmado.domain.Editora;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

public class EditoraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	
	public EditoraDTO() {
		
	}
	public EditoraDTO(Editora editora) {
		this.id = editora.getId();
		this.nome = editora.getNome();
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
