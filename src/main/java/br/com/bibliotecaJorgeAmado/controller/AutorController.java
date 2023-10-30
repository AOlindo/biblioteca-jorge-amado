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

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAutorDto;
import br.com.bibliotecaJorgeAmado.Dto.AutorDto;
import br.com.bibliotecaJorgeAmado.domain.Autor;
import br.com.bibliotecaJorgeAmado.service.AutorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AutorDto autorDto) {
		Autor autor = new Autor(autorDto);
		autorService.insert(autor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> update(@RequestBody @Valid AtualizarAutorDto atualizar, @PathVariable Integer id) {
		autorService.update(atualizar, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
