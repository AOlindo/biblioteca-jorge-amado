package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarEditoraDto;
import br.com.bibliotecaJorgeAmado.Dto.EditoraDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

@Entity
public class Editora implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	public Editora() {
		
	}
	public Editora(EditoraDto cadastroDto) {
		this.id = cadastroDto.getId();
		this.nome = cadastroDto.getNome();
		this.endereco = new Endereco(cadastroDto.getEndereco());
	}
	
	public void atualizaEditora(@Valid AtualizarEditoraDto atualizaDto) {
		if (atualizaDto.getNome() != null) {
			this.nome = atualizaDto.getNome();
		}
		if (atualizaDto.getEndereco() != null) {
			this.endereco.atualizandoEndereco(atualizaDto.getEndereco());
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
}
