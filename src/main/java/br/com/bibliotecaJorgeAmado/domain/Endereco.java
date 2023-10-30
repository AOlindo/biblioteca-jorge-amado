package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;

import br.com.bibliotecaJorgeAmado.Dto.EnderecoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	public Endereco() {

	}

	public Endereco(EnderecoDto enderecoDto) {
		this.logradouro = enderecoDto.getLogradouro();
		this.numero = enderecoDto.getNumero();
		this.bairro = enderecoDto.getBairro();
		this.cidade = enderecoDto.getCidade();
		this.uf = enderecoDto.getUf();
		this.cep = enderecoDto.getCep();
	}

	public void atualizandoEndereco(EnderecoDto atualiza) {
		this.logradouro = atualiza.getLogradouro();
		this.numero = atualiza.getNumero();
		this.bairro = atualiza.getBairro();
		this.cidade = atualiza.getCidade();
		this.uf = atualiza.getUf();
		this.cep = atualiza.getCep();
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
