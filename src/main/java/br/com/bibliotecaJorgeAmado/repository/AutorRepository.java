package br.com.bibliotecaJorgeAmado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bibliotecaJorgeAmado.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

	@Query("SELECT a FROM Autor a where a.nome like %:nome%")
	List<Autor> findAutorByNomeLike(String nome);

}
