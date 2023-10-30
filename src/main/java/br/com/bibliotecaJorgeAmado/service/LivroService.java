package br.com.bibliotecaJorgeAmado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarLivroDto;
import br.com.bibliotecaJorgeAmado.Dto.LivroDto;
import br.com.bibliotecaJorgeAmado.domain.Autor;
import br.com.bibliotecaJorgeAmado.domain.Editora;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.repository.EditoraRepository;
import br.com.bibliotecaJorgeAmado.repository.LivroRepository;
import jakarta.validation.Valid;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EditoraService editoraService;
	
	@Autowired
	private AutorService autorService;
	
	public Livro insert(LivroDto livroDto) {
		Editora editora = editoraService.findById(livroDto.getEditoraId());
		Autor autor = autorService.findById(livroDto.getAutorId());
		Livro livro = new Livro(livroDto);
		livro.setEditora(editora);
		livro.setAutor(autor);
		return salve(livro);
	}
	
	public Livro salve(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro update(@Valid AtualizarLivroDto atualizarDto, Integer id) {
		Livro livro = findById(id);
		livro.atualizarLivro(atualizarDto);
		return salve(livro);
	}
	
	public Livro findById(Integer id) {
		Livro livro = livroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id do livro não encontrado"));
		return livro;
	}


}
