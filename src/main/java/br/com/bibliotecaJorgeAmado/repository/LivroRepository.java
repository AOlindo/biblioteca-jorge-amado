package br.com.bibliotecaJorgeAmado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	

}
