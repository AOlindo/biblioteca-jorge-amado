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

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDto;
import br.com.bibliotecaJorgeAmado.Dto.AtualizarFuncionarioDto;
import br.com.bibliotecaJorgeAmado.Dto.AlunoDto;
import br.com.bibliotecaJorgeAmado.Dto.FuncionarioDto;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;
import br.com.bibliotecaJorgeAmado.service.AlunoService;
import br.com.bibliotecaJorgeAmado.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	public ResponseEntity<Funcionario> insert(@RequestBody FuncionarioDto cadatroDto) {
		Funcionario funcionario = new Funcionario(cadatroDto);
		funcionarioService.insert(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@RequestBody @Valid AtualizarFuncionarioDto atualizaDto, @PathVariable Integer id) {
		funcionarioService.update(atualizaDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> delete(@PathVariable Integer id) {
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity <List<Funcionario>> findAll() {
		List<Funcionario> funcionarios = funcionarioService.find();
		return ResponseEntity.ok(funcionarios);
	}

}
