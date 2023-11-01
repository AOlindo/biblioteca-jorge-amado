package br.com.bibliotecaJorgeAmado.Dto;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.domain.Aluno;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;

	private EnderecoDTO endereco;

	public AlunoDTO() {

	}

	public AlunoDTO(Aluno aluno) {
		super();
		this.nome = aluno.getNome();
		this.email = aluno.getEmail();
		this.cpf = aluno.getCpf();
		this.telefone = aluno.getTelefone();
		this.endereco = new EnderecoDTO(aluno.getEndereco());
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

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
