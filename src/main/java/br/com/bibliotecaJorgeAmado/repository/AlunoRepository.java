package br.com.bibliotecaJorgeAmado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {


}
