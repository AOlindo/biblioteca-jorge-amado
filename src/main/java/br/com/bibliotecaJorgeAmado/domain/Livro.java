package br.com.bibliotecaJorgeAmado.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarLivroDto;
import br.com.bibliotecaJorgeAmado.Dto.LivroDto;
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
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora Editora;
	
	public Livro() {
		
	}
	
	public Livro(LivroDto livroDto) {
		this.titulo = livroDto.getTitulo();
		this.descricao = livroDto.getDescricao();
	}
	
	public void atualizarLivro(AtualizarLivroDto atualizarDto) {
		if(atualizarDto.getTitulo() != null) {
			this.titulo = atualizarDto.getTitulo();
		}
		if(atualizarDto.getDescricao() != null) {
			this.descricao = atualizarDto.getDescricao();
		}
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
		return Editora;
	}

	public void setEditora(Editora editora) {
		Editora = editora;
	}
	
	

}
