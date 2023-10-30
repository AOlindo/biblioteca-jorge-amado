package br.com.bibliotecaJorgeAmado.Dto;

import jakarta.validation.constraints.NotEmpty;

public class EditoraDto {

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	private EnderecoDto endereco;

	public EditoraDto() {

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

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}

}
