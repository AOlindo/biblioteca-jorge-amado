package br.com.bibliotecaJorgeAmado.Dto;

public class AtualizarLivroDto {

	private String titulo;
	private String descricao;
	
	public AtualizarLivroDto() {
		
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
