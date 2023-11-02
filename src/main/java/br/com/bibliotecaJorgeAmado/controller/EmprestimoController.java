package br.com.bibliotecaJorgeAmado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibliotecaJorgeAmado.Dto.CadastroEmprestimoDTO;
import br.com.bibliotecaJorgeAmado.domain.Emprestimo;
import br.com.bibliotecaJorgeAmado.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;
	
	@PostMapping
	public ResponseEntity<Emprestimo> insert(@RequestBody CadastroEmprestimoDTO cadastroEmp){
		emprestimoService.insert(cadastroEmp);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
