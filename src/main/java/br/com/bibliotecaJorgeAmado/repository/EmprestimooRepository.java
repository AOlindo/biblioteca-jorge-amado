package br.com.bibliotecaJorgeAmado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.domain.Emprestimo;

public interface EmprestimooRepository extends JpaRepository<Emprestimo, Integer> {


}


