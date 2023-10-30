package br.com.bibliotecaJorgeAmado.Dto;

public class AtualizarEditoraDto {

	private String nome;
	private EnderecoDto endereco;

	public AtualizarEditoraDto() {

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
