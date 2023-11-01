package br.com.bibliotecaJorgeAmado.Dto;

public class AtualizarAlunoDTO {

	private String nome;
	private String telefone;
	private CadastroEnderecoDTO endereco;

	public AtualizarAlunoDTO() {

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

	public CadastroEnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(CadastroEnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	

}
