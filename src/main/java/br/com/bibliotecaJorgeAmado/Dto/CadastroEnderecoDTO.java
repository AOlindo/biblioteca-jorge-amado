package br.com.bibliotecaJorgeAmado.Dto;

import br.com.bibliotecaJorgeAmado.domain.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CadastroEnderecoDTO {

	private Integer id;
	@NotNull(message = "Preenchimento obrigatório")
	private String numero;
	@NotNull(message = "Preenchimento obrigatório")
	private String cep;
	private String complemento;

	public CadastroEnderecoDTO() {

	}

	public CadastroEnderecoDTO(@Valid Endereco obj) {
		this.numero = obj.getNumero();
		this.cep = obj.getCep();
		this.complemento = obj.getComplemento();

	}

	public void atualizandoEndereco(Endereco atualiza) {
		if (atualiza.getNumero() != null) {
			this.numero = getNumero();
		}
		if (atualiza.getCep() != null) {
			this.cep = getCep();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	

}
