package br.com.bibliotecaJorgeAmado.Dto;

public class AtualizarFuncionarioDto {

	private String nome;
	private String telefone;
	private EnderecoDto endereco;

	public AtualizarFuncionarioDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	

}
