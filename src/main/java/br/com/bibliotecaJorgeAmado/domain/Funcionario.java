package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;
import br.com.bibliotecaJorgeAmado.Dto.AtualizarFuncionarioDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroFuncionarioDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionario extends DadosPessoais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	public Funcionario() {
		
	}
	
	public Funcionario(CadastroFuncionarioDTO cadastroDto) {
		this.nome = cadastroDto.getNome();
		this.telefone = cadastroDto.getTelefone();
		this.cpf = cadastroDto.getCpf();
		this.endereco = new Endereco(cadastroDto.getEndereco());
	}

	public void atualizarFuncionario(AtualizarFuncionarioDTO atualizar) {
		if(atualizar.getNome() != null) {
			this.nome = atualizar.getNome();
		}
		if(atualizar.getTelefone() != null) {
			this.telefone = atualizar.getTelefone();
		}
		if(atualizar.getEndereco() != null) {
			this.endereco.atualizandoEndereco(atualizar.getEndereco());
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	

}
