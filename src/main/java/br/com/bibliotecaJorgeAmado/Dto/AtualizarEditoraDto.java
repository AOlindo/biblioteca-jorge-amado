package br.com.bibliotecaJorgeAmado.Dto;

public class AtualizarEditoraDTO {

	private String nome;
	private CadastroEnderecoDTO endereco;

	public AtualizarEditoraDTO() {

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
