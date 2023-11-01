package br.com.bibliotecaJorgeAmado.Dto;

import jakarta.validation.constraints.NotEmpty;

public class CadastroAutorDTO {

	private Integer id;
	@NotEmpty(message = "Campo obrigatorio")
	private String nome;
	@NotEmpty(message = "Campo obrigatorio")

	public CadastroAutorDTO() {

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
