package br.com.bibliotecaJorgeAmado.Dto;

import org.hibernate.validator.constraints.br.CPF;

import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class FuncionarioDto {

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	@CPF
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpf;
	@NotEmpty(message = "Preenchimento obrigatório")
	private EnderecoDto endereco;

	public FuncionarioDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
