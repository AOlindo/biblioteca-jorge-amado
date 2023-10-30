package br.com.bibliotecaJorgeAmado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarEditoraDto;
import br.com.bibliotecaJorgeAmado.domain.Editora;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository editoraRepository;

	public EditoraService(EditoraRepository editoraRepository) {
		this.editoraRepository = editoraRepository;
	}

	public Editora insert(Editora editora) {
		return editoraRepository.save(editora);

	}

	public Editora update(AtualizarEditoraDto editoraDto, Integer id) {
		Editora editora = findById(id);;
		editora.atualizaEditora(editoraDto);
		return editoraRepository.save(editora);
	}

	public List<Editora> findAll() {
		List<Editora> lista = editoraRepository.findAll();
		return lista;

	}

	public void delete(Integer id) {
		Editora editora = findById(id);
		editoraRepository.delete(editora);
	}
	
	public Editora findById(Integer id){
		Editora editora = editoraRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id da editora não encontrado"));
		return editora;
	}
}
