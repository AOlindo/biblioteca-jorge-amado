package br.com.bibliotecaJorgeAmado.Dto;

import br.com.bibliotecaJorgeAmado.domain.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CadastroEnderecoDTO {

	private Integer id;
	@NotNull(message = "Preenchimento obrigatório")
	private String logradouro;
	@NotNull(message = "Preenchimento obrigatório")
	private String numero;
	@NotNull(message = "Preenchimento obrigatório")
	private String bairro;
	@NotNull(message = "Preenchimento obrigatório")
	private String cidade;
	@NotNull(message = "Preenchimento obrigatório")
	private String uf;
	@NotNull(message = "Preenchimento obrigatório")
	private String cep;

	public CadastroEnderecoDTO() {

	}

	public CadastroEnderecoDTO(@Valid Endereco obj) {
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.bairro = obj.getBairro();
		this.cidade = obj.getCidade();
		this.uf = obj.getUf();
		this.cep = obj.getCep();

	}
	public void atualizandoEndereco(Endereco atualiza) {
		if(atualiza.getLogradouro() != null) {
			this.logradouro = getLogradouro();
		}
		if(atualiza.getNumero() != null){
			this.numero = getNumero();
		}
		if(atualiza.getBairro() != null) {
			this.bairro = getBairro();
		}
		if(atualiza.getCidade() != null) {
			this.cidade = getCidade();
		}
		if(atualiza.getUf() != null) {
			this.uf = getUf();
		}
		if(atualiza.getCep() != null) {
			this.cep = getCep();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
