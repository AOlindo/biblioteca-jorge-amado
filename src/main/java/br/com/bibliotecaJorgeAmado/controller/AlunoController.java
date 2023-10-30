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
import br.com.bibliotecaJorgeAmado.Dto.AlunoDto;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody AlunoDto cadatroDto) {
		Aluno aluno = new Aluno(cadatroDto);
		alunoService.insert(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> update(@RequestBody @Valid AtualizarAlunoDto atualizaDto, @PathVariable Integer id) {
		alunoService.update(atualizaDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> delete(@PathVariable Integer id) {
		alunoService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity <List<Aluno>> findAll() {
		List<Aluno> alunos = alunoService.findAll();
		return ResponseEntity.ok(alunos);
	}

}
