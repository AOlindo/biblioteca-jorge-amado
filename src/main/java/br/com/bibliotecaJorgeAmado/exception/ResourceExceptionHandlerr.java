package br.com.bibliotecaJorgeAmado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandlerr {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Error> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Id não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}

}
