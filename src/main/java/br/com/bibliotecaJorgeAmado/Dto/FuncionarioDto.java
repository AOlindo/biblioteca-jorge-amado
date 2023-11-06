package br.com.bibliotecaJorgeAmado.Dto;

import java.io.Serializable;
import br.com.bibliotecaJorgeAmado.Dto.AtualizarFuncionarioDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroFuncionarioDTO;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
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

	
	
	
	
	
	

}
