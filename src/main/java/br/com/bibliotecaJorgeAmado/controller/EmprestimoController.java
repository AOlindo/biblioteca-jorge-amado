package br.com.bibliotecaJorgeAmado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.AtualizarEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemEmprestimo;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Emprestimo;
import br.com.bibliotecaJorgeAmado.service.EmprestimoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping
	public ResponseEntity<Emprestimo> insert(@RequestBody CadastroEmprestimoDTO cadastroEmp) {
		emprestimoService.insert(cadastroEmp);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<ListagemEmprestimo>> findAll() {
		List<ListagemEmprestimo> emprestimo = emprestimoService.findAll();
		return ResponseEntity.ok(emprestimo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<ListagemEmprestimo>> findById(@PathVariable Integer id) {
		List<ListagemEmprestimo> emprestimo = emprestimoService.findById(id);
		return ResponseEntity.ok(emprestimo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo> update(@RequestBody @Valid AtualizarEmprestimoDTO atualizaDto,
			@PathVariable Integer id) {
		emprestimoService.update(atualizaDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		emprestimoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
