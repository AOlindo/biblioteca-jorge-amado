package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarLivroDTO;
import br.com.bibliotecaJorgeAmado.Dto.AutorDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroLivroDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemLivroDTO;
import br.com.bibliotecaJorgeAmado.enums.StatusEmprestimo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;
	
	private String url;
	private String isbn;
	
	public Livro() {
		
	}
	
	public Livro(CadastroLivroDTO livroDto) {
		this.titulo = livroDto.getTitulo();
		this.descricao = livroDto.getDescricao();
		this.isbn = livroDto.getIsbn();
	}
	
	public void atualizarLivro(AtualizarLivroDTO atualizarDto) {
		if(atualizarDto.getTitulo() != null) {
			this.titulo = atualizarDto.getTitulo();
		}
		if(atualizarDto.getDescricao() != null) {
			this.descricao = atualizarDto.getDescricao();
		}
	}
	
	public void listarLivros(ListagemLivroDTO listagemDto) {
		this.titulo = listagemDto.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	
	

}
