package br.com.bibliotecaJorgeAmado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bibliotecaJorgeAmado.Dto.CadastroAlunoDTO;
import br.com.bibliotecaJorgeAmado.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	@Query("SELECT a FROM Aluno a where a.nome like %:nome%")
	List<Aluno> findAlunosByNomeLike(String nome);
	
	@Query("SELECT a FROM Aluno a where a.nome = :nome")
	List<Aluno> buscarAlunoPorNome(String nome);
	
	public Aluno findByCpf(String cpf);

}


