package br.com.bibliotecaJorgeAmado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaJorgeAmado.domain.Endereco;
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
