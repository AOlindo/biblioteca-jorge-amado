package br.com.bibliotecaJorgeAmado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarLivroDto;
import br.com.bibliotecaJorgeAmado.Dto.LivroDto;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.service.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid LivroDto livroDto){
		livroService.insert(livroDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@RequestBody @Valid AtualizarLivroDto atualizaDto, @PathVariable Integer id){
		livroService.update(atualizaDto, id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
