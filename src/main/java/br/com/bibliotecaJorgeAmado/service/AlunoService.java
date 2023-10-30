package br.com.bibliotecaJorgeAmado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDto;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.exception.TratamentoException;
import br.com.bibliotecaJorgeAmado.repository.AlunoRepository;
import jakarta.validation.Valid;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public Aluno insert(Aluno aluno) {
		return alunoRepository.save(aluno);

	}

	public Aluno update(AtualizarAlunoDto atualizar, Integer id) {
		Aluno aluno = findById(id);
		aluno.atualizaAluno(atualizar);
		return alunoRepository.save(aluno);
	}

	public void delete(Integer id) {
		Aluno aluno = findById(id);
		alunoRepository.delete(aluno);
	}

	public List<Aluno> findAll() {
		List<Aluno> aluno = alunoRepository.findAll();
		return aluno;

	}
	
	public Aluno findById(Integer id){
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id da editora não encontrado"));
		return aluno;
	}
}
