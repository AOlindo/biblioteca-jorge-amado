package br.com.bibliotecaJorgeAmado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.CadastroAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.DadosCep;
import br.com.bibliotecaJorgeAmado.Dto.ListagemAlunoDTO;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.exception.InternalServerErrorException;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.exception.RegraNegocioException;
import br.com.bibliotecaJorgeAmado.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private EnderecoService enderecoService;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public void setarDadosEnderecoAluno(Aluno aluno) {
		try {
			DadosCep dados = enderecoService.buscaEndereco(aluno.getEndereco().getCep());
			aluno.getEndereco().setLogradouro(dados.getLogradouro());
			aluno.getEndereco().setBairro(dados.getBairro());
			aluno.getEndereco().setCidade(dados.getLocalidade());
			aluno.getEndereco().setUf(dados.getUf());
		} catch (RegraNegocioException e) {
			throw new RegraNegocioException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerErrorException(e.getMessage());
		}

	}

	public Aluno insert(Aluno aluno) {

		setarDadosEnderecoAluno(aluno);

		return salve(aluno);

	}

	public Aluno salve(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno update(AtualizarAlunoDTO atualizar, Integer id) {
		Aluno aluno = findById(id);

		if (!aluno.getCpf().equals(atualizar.getEndereco().getCep())) {
			setarDadosEnderecoAluno(aluno);
		}

		aluno.atualizaAluno(atualizar);
		return alunoRepository.save(aluno);
	}

	public void delete(Integer id) {
		Aluno aluno = findById(id);
		alunoRepository.delete(aluno);
	}

	public List<Aluno> findAll() {
		List<Aluno> aluno = alunoRepository.findAll();
		return aluno;

	}

	public Aluno findById(Integer id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id do aluno não encontrado"));
		return aluno;
	}

//	public List<ListagemAlunoDTO> listaPorNomeLike(String nome){
//		return alunoRepository.findAlunosByNomeLike(nome).stream().map(aluno -> new ListagemAlunoDTO(aluno)).collect(Collectors.toList());
//	}

	public List<Aluno> buscarAlunoPorNome(String nome) {
		List<Aluno> aluno = alunoRepository.buscarAlunoPorNome(nome);
		return aluno;
	}

	public Aluno buscarAlunoPorCpf(String cpf) {
		Aluno aluno = alunoRepository.findByCpf(cpf);
		return aluno;
	}
}
