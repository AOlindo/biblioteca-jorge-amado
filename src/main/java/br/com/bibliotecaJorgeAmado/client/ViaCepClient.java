package br.com.bibliotecaJorgeAmado.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bibliotecaJorgeAmado.Dto.DadosCep;

@FeignClient(value = "ViaCepClient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

	@GetMapping("/{cep}/json")
	public ResponseEntity<DadosCep> getEndereco(@PathVariable String cep);
}
