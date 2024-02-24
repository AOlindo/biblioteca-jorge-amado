package br.com.bibliotecaJorgeAmado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bibliotecaJorgeAmado.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	UserDetails findByLogin (String login);
	
	Boolean existsByLogin(String login);
	
	Optional<UserDetails> findOneByLogin(String login);


}
