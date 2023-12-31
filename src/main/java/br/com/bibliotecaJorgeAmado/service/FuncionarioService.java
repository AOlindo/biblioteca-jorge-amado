package br.com.bibliotecaJorgeAmado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaJorgeAmado.Dto.AtualizarAlunoDTO;
import br.com.bibliotecaJorgeAmado.Dto.AtualizarFuncionarioDTO;
import br.com.bibliotecaJorgeAmado.domain.Aluno;
import br.com.bibliotecaJorgeAmado.domain.Funcionario;
import br.com.bibliotecaJorgeAmado.domain.Livro;
import br.com.bibliotecaJorgeAmado.exception.ObjectNotFoundException;
import br.com.bibliotecaJorgeAmado.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario insert(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		
	}	
	public void delete(Integer id) {
		Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id do funcionário não encontrado"));
		funcionarioRepository.delete(funcionario);
	}
	
	public Funcionario update(AtualizarFuncionarioDTO atualizar, Integer id) {
		Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Id do funcionário não encontrado"));
		funcionario.atualizarFuncionario(atualizar);
		return funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> find() {
		List<Funcionario> funcionario = funcionarioRepository.findAll();
		return funcionario;
		
	}
	public Funcionario findById(Integer id) {
		Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id do funcionario não encontrado"));
		return funcionario;
	}
}
