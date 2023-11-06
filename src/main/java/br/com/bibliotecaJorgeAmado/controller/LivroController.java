package br.com.bibliotecaJorgeAmado.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarLivroDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroLivroDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemLivroDTO;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.service.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid CadastroLivroDTO livroDto){
		livroService.insert(livroDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@RequestBody @Valid AtualizarLivroDTO atualizaDto, @PathVariable Integer id){
		livroService.update(atualizaDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}/pictures")
	public ResponseEntity<Void>uploadProfilePicture(@RequestParam(name = "file") MultipartFile file, @PathVariable Integer id){
		URI uri = livroService.uploadProfilePicture(file, id);
		System.out.println(uri);
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ListagemLivroDTO>> findAll(){
		List<ListagemLivroDTO> livros = livroService.find();
		return ResponseEntity.ok(livros);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delelte(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}

	
	
	
	
	
	
}
