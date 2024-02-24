package br.com.bibliotecaJorgeAmado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bibliotecaJorgeAmado.Dto.AuthenticationDTO;
import br.com.bibliotecaJorgeAmado.Dto.LoginResponseDTO;
import br.com.bibliotecaJorgeAmado.Dto.RegistrarDTO;
import br.com.bibliotecaJorgeAmado.domain.Usuario;
import br.com.bibliotecaJorgeAmado.exception.RegraNegocioException;
import br.com.bibliotecaJorgeAmado.infra.TokenService;
import br.com.bibliotecaJorgeAmado.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	public String login(@RequestBody @Valid AuthenticationDTO authenticationDto) {
		var loginESenha = new UsernamePasswordAuthenticationToken(authenticationDto.login(), authenticationDto.senha());
		// Aqui, o AuthenticationManager autentica o usuário
		var auth = this.authenticationManager.authenticate(loginESenha);
		// Se a autenticação for bem-sucedida, gera o token
		var token = tokenService.gerarToken((Usuario) auth.getPrincipal());
		return token;
		 
	}
	
	public Usuario registrarUsuario (RegistrarDTO registrarDto) {
		// Se este login já existir no banco de dado, lance uma exception
		if(this.usuarioRepository.existsByLogin(registrarDto.login())) {
			throw new RegraNegocioException("O login já existe no banco de dados");
		}

		// Se não, cadastre o novo usuario
		String senhaCriptografada = new BCryptPasswordEncoder().encode(registrarDto.senha());
		Usuario novoUsuario = new Usuario(registrarDto.login(), senhaCriptografada, registrarDto.role());
		this.usuarioRepository.save(novoUsuario);
		return novoUsuario;
	}
	
	
}
