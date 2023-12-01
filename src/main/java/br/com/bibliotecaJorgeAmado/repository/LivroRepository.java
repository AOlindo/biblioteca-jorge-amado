package br.com.bibliotecaJorgeAmado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.Dto.ListagemLivroDTO;
import br.com.bibliotecaJorgeAmado.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	List<Livro> findByOrderByTitulo();
	
	
}
