package br.com.bibliotecaJorgeAmado.Dto;

import java.time.LocalDate;

import br.com.bibliotecaJorgeAmado.enums.StatusEmprestimo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CadastroEmprestimoDTO {

	private Integer id;
	@NotNull(message = "Preenchimento obrigatório")
	private Integer alunoId;
	@NotNull(message = "Preenchimento obrigatório")
	private Integer funcionarioId;
	@NotNull(message = "Preenchimento obrigatório")
	private Integer livroId;

	private LocalDate dataDoEmprestimo;
	private LocalDate dataDaDevolucao;
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
