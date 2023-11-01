package br.com.bibliotecaJorgeAmado.Dto;

import jakarta.validation.constraints.NotNull;

public class CadastroLivroDTO {

	@NotNull(message = "Campo obrigatorio")
	private Integer editoraId;
	@NotNull(message = "Campo obrigatorio")
	private Integer autorId;
	@NotNull(message = "Campo obrigatorio")
	private String titulo;
	@NotNull(message = "Campo obrigatorio")
	private String descricao;
	
	public CadastroLivroDTO() {
		
	}
	

	public Integer getEditoraId() {
		return editoraId;
	}


	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}


	public Integer getAutorId() {
		return autorId;
	}


	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
