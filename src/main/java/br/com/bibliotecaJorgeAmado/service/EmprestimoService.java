package br.com.bibliotecaJorgeAmado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.CadastroEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Emprestimo;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.repository.EmprestimooRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimooRepository emprestimooRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private LivroService livroService;
	
	public EmprestimoService(EmprestimooRepository emprestimooRepository) {
		this.emprestimooRepository = emprestimooRepository;
	}

	public Emprestimo insert(CadastroEmprestimoDTO emprestimo) {
		Aluno aluno = alunoService.findById(emprestimo.getAlunoId());
		Funcionario funcionario = funcionarioService.findById(emprestimo.getFuncionarioId());
		Livro livro = livroService.findById(emprestimo.getLivroId());
		Emprestimo emp = new Emprestimo(emprestimo);
		emp.setAluno(aluno);
		emp.setFuncionario(funcionario);
		emp.setLivro(livro);
		return salvar (emp);
	}

	private Emprestimo salvar(Emprestimo emp) {
		return emprestimooRepository.save(emp);
	}

//	public Aluno update(AtualizarAlunoDTO atualizar, Integer id) {
//		Aluno aluno = findById(id);
//		aluno.atualizaAluno(atualizar);
//		return alunoRepository.save(aluno);
//	}
//
//	public void delete(Integer id) {
//		Aluno aluno = findById(id);
//		alunoRepository.delete(aluno);
//	}
//
//	public List<Aluno> findAll() {
//		List<Aluno> aluno = alunoRepository.findAll();
//		return aluno;
//
//	}
//	
//	public Aluno findById(Integer id){
//		Aluno aluno = alunoRepository.findById(id)
//				.orElseThrow(() -> new ObjectNotFoundException("Id da editora não encontrado"));
//		return aluno;
//	}
//	
//	public List<ListagemAlunoDTO> listaPorNomeLike(String nome){
//		return alunoRepository.findAlunosByNomeLike(nome).stream().map(aluno -> new ListagemAlunoDTO(aluno)).collect(Collectors.toList());
//	}
}
