package br.com.bibliotecaJorgeAmado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {


}
