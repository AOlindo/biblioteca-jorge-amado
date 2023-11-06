package br.com.bibliotecaJorgeAmado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemEmprestimo;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Emprestimo;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
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

	public Emprestimo insert(CadastroEmprestimoDTO emprestimo) {
		Aluno aluno = alunoService.findById(emprestimo.getAlunoId());
		Funcionario funcionario = funcionarioService.findById(emprestimo.getFuncionarioId());
		Livro livro = livroService.findById(emprestimo.getLivroId());
		Emprestimo emp = new Emprestimo(emprestimo);
		emp.setAluno(aluno);
		emp.setFuncionario(funcionario);
		emp.setLivro(livro);
		return salvar(emp);
	}

	private Emprestimo salvar(Emprestimo emp) {
		return emprestimoRepository.save(emp);
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
