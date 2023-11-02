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

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAutorDTO;
import br.com.bibliotecaJorgeAmado.Dto.AutorDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroAutorDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemAutorDTO;
import br.com.bibliotecaJorgeAmado.domain.Autor;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.service.AutorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CadastroAutorDTO autorDto) {
		autorService.insert(autorDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> update(@RequestBody @Valid AtualizarAutorDTO atualizar, @PathVariable Integer id) {
		autorService.update(atualizar, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Autor>> findAll(){
		List<Autor> autores = autorService.findAll();
		return ResponseEntity.ok(autores);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		autorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/nome")
	public ResponseEntity<List<ListagemAutorDTO>> listaPorNome(String nome) {
		List<ListagemAutorDTO> lista = autorService.listaPorNomeLike(nome);
		return ResponseEntity.status(lista.isEmpty()?HttpStatus.NO_CONTENT : HttpStatus.OK).body(lista);
	}
	

}
