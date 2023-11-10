package com.dev.bookstore.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ExceptionHandlerError {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objNotFoundException(ObjectNotFoundException e, ServletRequest reques) {
		StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(ViolacaoDeDadosException.class)
	public ResponseEntity<StandardError> violacaoDeDadosException(ViolacaoDeDadosException e, ServletRequest reques) {
		StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationException(MethodArgumentNotValidException e, ServletRequest reques) {
		ValidationError error = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				"Erro na validação dos Campos");

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());

		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
