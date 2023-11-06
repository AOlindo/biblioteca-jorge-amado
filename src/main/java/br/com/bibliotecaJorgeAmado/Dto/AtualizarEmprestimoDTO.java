package br.com.bibliotecaJorgeAmado.Dto;

import java.time.LocalDate;

import br.com.bibliotecaJorgeAmado.enums.StatusEmprestimo;

public class AtualizarEmprestimoDTO {

	private LocalDate dataDaDevolucao;
	private StatusEmprestimo status;

	public AtualizarEmprestimoDTO() {

	}

	public LocalDate getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public void setDataDaDevolucao(LocalDate dataDaDevolucao) {
		this.dataDaDevolucao = dataDaDevolucao;
	}

	public StatusEmprestimo getStatus() {
		return status;
	}

	public void setStatus(StatusEmprestimo status) {
		this.status = status;
	}

	
	

	

	
	

}
