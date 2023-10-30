package br.com.bibliotecaJorgeAmado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {


}
