package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroAlunoDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

@Entity
public class Aluno extends DadosPessoais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	
	public Aluno() {

	}

	public Aluno(CadastroAlunoDTO cadastroDto) {
		super();
		this.nome = cadastroDto.getNome();
		this.email = cadastroDto.getEmail();
		this.cpf = cadastroDto.getCpf();
		this.telefone = cadastroDto.getTelefone();
		this.endereco = new Endereco(cadastroDto.getEndereco());
	}

	public void atualizaAluno(@Valid AtualizarAlunoDTO atualizaDto) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
