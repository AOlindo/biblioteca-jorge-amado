package br.com.bibliotecaJorgeAmado.Dto;

import org.hibernate.validator.constraints.br.CPF;

import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class AlunoDto {

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	@Email
	@NotEmpty(message = "Preenchimento obrigatório")
	private String email;
	@CPF
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpf;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	@NotEmpty(message = "Preenchimento obrigatório")
	private EnderecoDto endereco;

	public AlunoDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
