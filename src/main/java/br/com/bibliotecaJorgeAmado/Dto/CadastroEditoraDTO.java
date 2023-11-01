package br.com.bibliotecaJorgeAmado.Dto;

import jakarta.validation.constraints.NotEmpty;

public class CadastroEditoraDTO {

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	private CadastroEnderecoDTO endereco;

	public CadastroEditoraDTO() {

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

	public CadastroEnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(CadastroEnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
