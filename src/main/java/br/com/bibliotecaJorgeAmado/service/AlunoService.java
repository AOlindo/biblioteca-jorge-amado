package br.com.bibliotecaJorgeAmado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemAlunoDTO;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.repository.AlunoRepository;

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

	public Aluno update(AtualizarAlunoDTO atualizar, Integer id) {
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
	
	public List<ListagemAlunoDTO> listaPorNomeLike(String nome){
		return alunoRepository.findAlunosByNomeLike(nome).stream().map(aluno -> new ListagemAlunoDTO(aluno)).collect(Collectors.toList());
	}
}
