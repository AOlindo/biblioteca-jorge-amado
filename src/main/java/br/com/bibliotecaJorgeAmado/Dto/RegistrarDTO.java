package br.com.bibliotecaJorgeAmado.Dto;

import br.com.bibliotecaJorgeAmado.enums.UsuarioRole;

public record RegistrarDTO(String login, String senha, UsuarioRole role) {

}
