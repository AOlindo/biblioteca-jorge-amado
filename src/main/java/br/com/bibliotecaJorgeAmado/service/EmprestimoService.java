package br.com.bibliotecaJorgeAmado.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemEmprestimo;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Emprestimo;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.enums.StatusEmprestimo;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.exception.RegraNegocioException;
import br.com.bibliotecaJorgeAmado.repository.EmprestimooRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimooRepository emprestimoRepository;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private LivroService livroService;

	public EmprestimoService(EmprestimooRepository emprestimooRepository) {
		this.emprestimoRepository = emprestimooRepository;
	}

	public Emprestimo insert(CadastroEmprestimoDTO emprestimoDto) {
		
//		Emprestimo c = emprestimoRepository.buscarEmprestimosPorIdEStatus(emprestimo.getLivroId(), Arrays.asList(StatusEmprestimo.RENOVADO.toString(), StatusEmprestimo.RESERVADO.toString() ));
//		if (emprestimoEncontrado != null) {
//			throw new RuntimeException("Livro ja alugado");
//		}
		
//		List<StatusEmprestimo> status = new ArrayList<>();
//		status.add(StatusEmprestimo.RENOVADO);
//		status.add(StatusEmprestimo.RESERVADO);
//
//		Page<Emprestimo> emprestimoEncontradoPage = emprestimoRepository.buscarEmprestimosPorIdEStatus(emprestimo.getLivroId(), status, PageRequest.of(0, 1));
//		
//		if(!emprestimoEncontradoPage.getContent().isEmpty()) {
//			throw new RuntimeException("Livro ja alugado");
//		}
//		
		Boolean existeEmprestimosPorIdEStatus = emprestimoRepository.existeEmprestimosPorIdEStatus(emprestimoDto.getLivroId(), Arrays.asList(StatusEmprestimo.RENOVADO, StatusEmprestimo.RESERVADO ));
		if (existeEmprestimosPorIdEStatus) {
			throw new RegraNegocioException("O livro já está alugado por outro aluno");
		}
		
		Aluno aluno = alunoService.findById(emprestimoDto.getAlunoId());
		Funcionario funcionario = funcionarioService.findById(emprestimoDto.getFuncionarioId());
		Livro livro = livroService.findById(emprestimoDto.getLivroId());
		Emprestimo emprestimo = new Emprestimo(emprestimoDto);
		emprestimo.setAluno(aluno);
		emprestimo.setFuncionario(funcionario);
		emprestimo.setLivro(livro);
		return salvar(emprestimo);
	}

	private Emprestimo salvar(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo buscarPorId(Integer id) {
		Emprestimo eemprestimo = emprestimoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id do emprestimo não encontrado"));
		return eemprestimo;
	}

	public List<ListagemEmprestimo> findAll() {
		List<ListagemEmprestimo> emprestimo = emprestimoRepository.findAll().stream()
				.map(emprestimos -> new ListagemEmprestimo(emprestimos)).collect(Collectors.toList());
		return emprestimo;
	}

	public List<ListagemEmprestimo> findById(Integer id) {
		List<ListagemEmprestimo> emprestimo = emprestimoRepository.findById(id).stream()
				.map(emprestimos -> new ListagemEmprestimo(emprestimos)).collect(Collectors.toList());
		return emprestimo;
	}

	public Emprestimo update(AtualizarEmprestimoDTO atualizar, Integer id) {
		Emprestimo emprestimo = buscarPorId(id);
		emprestimo.atualizaEmprestimo(atualizar);
		return emprestimoRepository.save(emprestimo);
	}

	public void delete(Integer id) {
		Emprestimo emprestimo = buscarPorId(id);
		emprestimoRepository.delete(emprestimo);
	}
}

//
//public List<ListagemAlunoDTO> listaPorNomeLike(String nome){
//return alunoRepository.findAlunosByNomeLike(nome).stream().map(aluno -> new ListagemAlunoDTO(aluno)).collect(Collectors.toList());
//}
