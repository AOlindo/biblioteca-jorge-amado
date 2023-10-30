package br.com.bibliotecaJorgeAmado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAutorDto;
import br.com.bibliotecaJorgeAmado.domain.Autor;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	public Autor insert(Autor autor) {
		return autorRepository.save(autor);

	}

	public Autor update(AtualizarAutorDto autorDto, Integer id) {
		Autor autor = findById(id);
		autor.atualizaAutor(autorDto);
		return autorRepository.save(autor);
	}

	public List<Autor> findAll() {
		List<Autor> lista = autorRepository.findAll();
		return lista;

	}

	public void delete(Integer id) {
		Autor autor = findById(id);
		autorRepository.delete(autor);
	}
	
	public Autor findById(Integer id){
		Autor autor = autorRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id do Autor não encontrado"));
		return autor;
	}
}
