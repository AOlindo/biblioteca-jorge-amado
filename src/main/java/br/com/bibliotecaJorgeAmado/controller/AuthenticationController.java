package br.com.bibliotecaJorgeAmado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibliotecaJorgeAmado.Dto.AuthenticationDTO;
import br.com.bibliotecaJorgeAmado.Dto.LoginResponseDTO;
import br.com.bibliotecaJorgeAmado.Dto.RegistrarDTO;
import br.com.bibliotecaJorgeAmado.domain.Usuario;
import br.com.bibliotecaJorgeAmado.infra.TokenService;
import br.com.bibliotecaJorgeAmado.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDto) {
		String token = usuarioService.login(authenticationDto);
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity registrar(@RequestBody @Valid RegistrarDTO registrarDto) {
		usuarioService.registrarUsuario(registrarDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
}
