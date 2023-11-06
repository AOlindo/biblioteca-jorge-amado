package br.com.bibliotecaJorgeAmado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandlerr {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Error> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Id não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}
	@ExceptionHandler(FileException.class)
	public ResponseEntity<Error> file(FileException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro de arquivo", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
	@ExceptionHandler(TratamentoException.class)
	public ResponseEntity<Error> file(TratamentoException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Livro alugado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<Error> amazonService(AmazonServiceException e, HttpServletRequest request) {
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
		Error erro = new Error(System.currentTimeMillis(), code.value(), "Erro Amazon Service", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(code).body(erro);

	}
	
	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<Error> amazonClient(AmazonClientException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro Amazon Client", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
		
	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<Error> amazonS3(AmazonS3Exception e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro S3", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
}
