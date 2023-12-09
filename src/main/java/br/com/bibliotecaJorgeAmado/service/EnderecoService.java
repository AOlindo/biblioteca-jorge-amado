package br.com.bibliotecaJorgeAmado.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.bibliotecaJorgeAmado.Dto.DadosCep;
import br.com.bibliotecaJorgeAmado.client.ViaCepClient;
import br.com.bibliotecaJorgeAmado.exception.InternalServerErrorException;
import br.com.bibliotecaJorgeAmado.exception.RegraNegocioException;

@Service
public class EnderecoService {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ViaCepClient viaCepClient;

	public DadosCep buscaEndereco(String cep) throws RegraNegocioException {

		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

		HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new RegraNegocioException("Endereço inválido! Digite o CEP sem ponto e sem traço");
			} else if (response.statusCode() >= 500) {
				throw new RegraNegocioException("Erro na busca do endereço");
			}

			return mapper.readValue(response.body(), DadosCep.class);
		} catch (IOException | InterruptedException e) {
			throw new InternalServerErrorException(e.getMessage());
		}

	}

	public DadosCep buscaEnderecoRestTemplate(String cep) throws RegraNegocioException {

		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

		ResponseEntity<DadosCep> response = restTemplate.getForEntity(endereco, DadosCep.class);

		if (response.getStatusCode().value() >= 400) {
			throw new RegraNegocioException("Endereço inválido! Digite o CEP sem ponto e sem traço");
		} else if (response.getStatusCode().value() >= 500) {
			throw new RegraNegocioException("Erro na busca do endereço");
		}

		return response.getBody();

	}

	public DadosCep buscaEnderecoFeign(String cep) throws RegraNegocioException {

		ResponseEntity<DadosCep> response = viaCepClient.getEndereco(cep);

		if (response.getStatusCode().value() >= 400) {
			throw new RegraNegocioException("Endereço inválido! Digite o CEP sem ponto e sem traço");
		} else if (response.getStatusCode().value() >= 500) {
			throw new RegraNegocioException("Erro na busca do endereço");
		}

		return response.getBody();

	}

}
