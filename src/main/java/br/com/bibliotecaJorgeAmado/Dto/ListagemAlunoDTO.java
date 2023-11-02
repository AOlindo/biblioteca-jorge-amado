package br.com.bibliotecaJorgeAmado.Dto;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.domain.Aluno;

public class ListagemAlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String telefone;

	public ListagemAlunoDTO() {

	}

	public ListagemAlunoDTO(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.email = aluno.getEmail();
		this.telefone = aluno.getTelefone();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
