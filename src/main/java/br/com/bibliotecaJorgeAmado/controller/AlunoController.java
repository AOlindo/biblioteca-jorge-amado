package br.com.bibliotecaJorgeAmado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemAlunoDTO;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	public ResponseEntity<Aluno> insert(@Valid @RequestBody CadastroAlunoDTO cadatroDto) {
		Aluno aluno = new Aluno(cadatroDto);
		alunoService.insert(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> update(@Valid @RequestBody AtualizarAlunoDTO atualizaDto, @PathVariable Integer id) {
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
	
	
//	@GetMapping("/nome")
//	public ResponseEntity<List<ListagemAlunoDTO>> listaPorNome(String nome) {
//		List<ListagemAlunoDTO> lista = alunoService.listaPorNomeLike(nome);
//		return ResponseEntity.status(lista.isEmpty()?HttpStatus.NO_CONTENT : HttpStatus.OK).body(lista);
//	}
	
	@GetMapping("/nome")
	public ResponseEntity <List<Aluno>> buscarPorNome(@Param(value = "nome") String nome) {
		List<Aluno> alunos = alunoService.buscarAlunoPorNome(nome);
		return ResponseEntity.ok(alunos);
	}
	
	@GetMapping("/cpf")
	public ResponseEntity<Aluno> buscarAlunoPorCpf(String cpf){
		Aluno aluno = alunoService.buscarAlunoPorCpf(cpf);
		return ResponseEntity.ok(aluno);
	}

}
