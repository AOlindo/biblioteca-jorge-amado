package br.com.bibliotecaJorgeAmado.Dto;

import java.time.LocalDate;

import br.com.bibliotecaJorgeAmado.enums.StatusEmprestimo;
import jakarta.validation.constraints.NotEmpty;

public class CadastroEmprestimoDTO {

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	private Integer alunoId;
	@NotEmpty(message = "Preenchimento obrigatório")
	private Integer funcionarioId;
	@NotEmpty(message = "Preenchimento obrigatório")
	private Integer livroId;
	@NotEmpty(message = "Preenchimento obrigatório")
	private LocalDate dataDoEmprestimo;

	private LocalDate dataDaDevolucao;

	@NotEmpty(message = "Preenchimento obrigatório")
	private StatusEmprestimo statusEmprestimo;

	public CadastroEmprestimoDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
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

	public StatusEmprestimo getStatusEmprestimo() {
		return statusEmprestimo;
	}

	public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}

}
