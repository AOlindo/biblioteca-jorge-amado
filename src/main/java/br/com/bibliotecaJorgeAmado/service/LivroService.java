package br.com.bibliotecaJorgeAmado.service;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarLivroDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroLivroDTO;
import br.com.bibliotecaJorgeAmado.Dto.ListagemLivroDTO;
import br.com.bibliotecaJorgeAmado.domain.Autor;
import br.com.bibliotecaJorgeAmado.domain.Editora;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
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
	
	@Autowired
	private ImagemService imagemService;
	
	@Autowired
	private S3Service s3Service;
	
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private Integer size;
	
	public Livro insert(CadastroLivroDTO livroDto) {
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
	
	public Livro update(@Valid AtualizarLivroDTO atualizarDto, Integer id) {
		Livro livro = findById(id);
		livro.atualizarLivro(atualizarDto);
		return salve(livro);
	}
	
	public Livro findById(Integer id) {
		Livro livro = livroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id do livro não encontrado"));
		return livro;
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile, Integer livroId) {
		Livro livro = findById(livroId);
		
		BufferedImage jpgImage = imagemService.getJpgImageFromFile(multipartFile);
//		jpgImage = imagemService.cropSquare(jpgImage);
		jpgImage = imagemService.resize(jpgImage, size);

		String fileName = prefix + "/" + livro.getId() + ".jpg";
		URI uri = s3Service.uploadFile(imagemService.getInputStream(jpgImage, "jpg"), fileName, "image");
		livro.setUrl(uri.toString());
		livroRepository.save(livro);
		return uri;
	}
	
	public List<ListagemLivroDTO> find(Sort sort) {
		List<ListagemLivroDTO> livro = livroRepository.findAll().stream().map(livros -> new ListagemLivroDTO(livros)).collect(Collectors.toList());
		return livro;
		
	}
	
	public void delete(Integer id) {
		Livro livro = findById(id);
		livroRepository.delete(livro);
	}
	
	public List<ListagemLivroDTO> ordernarPorTitulo() {
		List<ListagemLivroDTO> livro = livroRepository.findByOrderByTitulo().stream().map(livros -> new ListagemLivroDTO(livros)).collect(Collectors.toList());
		return livro;
		
	}
	
	

}
