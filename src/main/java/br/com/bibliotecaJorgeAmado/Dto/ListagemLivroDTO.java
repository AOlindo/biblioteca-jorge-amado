package br.com.bibliotecaJorgeAmado.Dto;

import br.com.bibliotecaJorgeAmado.domain.Livro;

public class ListagemLivroDTO {

	private Integer id;
	private AutorDTO autor;
	private String titulo;
	private String descricao;
	private EditoraDTO editora;

	public ListagemLivroDTO(Livro livro) {
		this.id = livro.getId();
		this.autor = new AutorDTO(livro.getAutor());
		this.titulo = livro.getTitulo();
		this.descricao = livro.getDescricao();
		this.editora = new EditoraDTO(livro.getEditora());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
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

	public EditoraDTO getEditora() {
		return editora;
	}

	public void setEditora(EditoraDTO editora) {
		this.editora = editora;
	}

}
