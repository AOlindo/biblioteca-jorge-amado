package br.com.bibliotecaJorgeAmado.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.bibliotecaJorgeAmado.domain.Emprestimo;
import br.com.bibliotecaJorgeAmado.enums.StatusEmprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

	@Query(value = "SELECT e.* FROM emprestimo e where e.livro_id = :id and e.status_emprestimo in (:status) ORDER BY ID DESC LIMIT 1", nativeQuery = true)
	Emprestimo buscarEmprestimosPorIdEStatus(Integer id, List<String> status);
	
	@Query(value = "SELECT e FROM Emprestimo e where e.livro.id = :id and e.status in (:status)")
	Page<Emprestimo>  buscarEmprestimosPorIdEStatus(Integer id, List<StatusEmprestimo> status, Pageable page);
	
	@Query(value = "SELECT case  when count(e.id) > 0 then true else false end FROM Emprestimo e where e.livro.id = :id and e.status in (:status)")
	Boolean  existeEmprestimosPorIdEStatus(Integer id, List<StatusEmprestimo> status);
	
	Page<Emprestimo> findAll(Pageable pageable);
	
	
}


