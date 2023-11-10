package com.dev.bookstore.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldsMessage> fieldError = new ArrayList<>();

	public ValidationError(LocalDateTime timestamp, Integer status, String menssage) {
		super(timestamp, status, menssage);
		// TODO Auto-generated constructor stub
	}

	public List<FieldsMessage> getFieldError() {
		return fieldError;
	}

	public void addError(String fieldName, String message) {
		this.fieldError.add(new FieldsMessage(fieldName, message));
	}

}
