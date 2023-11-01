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

import br.com.bibliotecaJorgeAmado.Dto.AtualizarEditoraDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroEditoraDTO;
import br.com.bibliotecaJorgeAmado.domain.Editora;
import br.com.bibliotecaJorgeAmado.service.EditoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraService editoraService;

	@PostMapping
	public ResponseEntity<Editora> insert(@RequestBody CadastroEditoraDTO cadastroDto) {
		Editora editora = new Editora(cadastroDto);
		editoraService.insert(editora);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Editora> update(@RequestBody @Valid AtualizarEditoraDTO atualizaEditoraDto, @PathVariable Integer id) {
		editoraService.update(atualizaEditoraDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping
	public ResponseEntity<List<Editora>> findAll() {
		List<Editora> editoras = editoraService.findAll();
		return ResponseEntity.ok(editoras);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Editora> delete(@PathVariable Integer id){
		editoraService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
