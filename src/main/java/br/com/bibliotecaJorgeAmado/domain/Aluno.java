package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDto;
import br.com.bibliotecaJorgeAmado.Dto.AlunoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Aluno() {

	}

	public Aluno(AlunoDto cadastroDto) {
		super();
		this.nome = cadastroDto.getNome();
		this.email = cadastroDto.getEmail();
		this.cpf = cadastroDto.getCpf();
		this.telefone = cadastroDto.getTelefone();
		this.endereco = new Endereco(cadastroDto.getEndereco());
	}

	public void atualizaAluno(@Valid AtualizarAlunoDto atualizaDto) {
		if (atualizaDto.getNome() != null) {
			this.nome = atualizaDto.getNome();
		}

		if (atualizaDto.getTelefone() != null) {
			this.telefone = atualizaDto.getTelefone();
		}
		if (atualizaDto.getEndereco() != null) {
			this.endereco.atualizandoEndereco(atualizaDto.getEndereco());
		}

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
