package br.com.bibliotecaJorgeAmado.Dto;

import java.time.LocalDate;

import br.com.bibliotecaJorgeAmado.domain.Emprestimo;

public class ListagemEmprestimo {

	private Integer id;
	private AlunoDTO aluno;
	private FuncionarioDTO funcionario;
	private LivroDTO livro;
	private LocalDate dataDoEmprestimo;
	private LocalDate dataDaDevolucao;
	
	public ListagemEmprestimo(Emprestimo emprestimo) {
		this.id = emprestimo.getId();
		this.aluno = new AlunoDTO(emprestimo.getAluno());
		this.funcionario = new FuncionarioDTO(emprestimo.getFuncionario());
		this.livro = new LivroDTO(emprestimo.getLivro());
		this.dataDoEmprestimo = LocalDate.now();
		this.dataDaDevolucao = LocalDate.now().plusDays(15);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public LivroDTO getLivro() {
		return livro;
	}

	public void setLivro(LivroDTO livro) {
		this.livro = livro;
	}

	public LocalDate getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}

	public void setDataDoEmprestimo(LocalDate dataDoEmprestimo) {
		this.dataDoEmprestimo = dataDoEmprestimo;
	}

	public LocalDate getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public void setDataDaDevolucao(LocalDate dataDaDevolucao) {
		this.dataDaDevolucao = dataDaDevolucao;
	}
	
	
}
