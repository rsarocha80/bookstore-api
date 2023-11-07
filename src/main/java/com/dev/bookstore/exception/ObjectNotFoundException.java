package com.dev.bookstore.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String menssage, Throwable cause) {
		super(menssage, cause);
	}

	public ObjectNotFoundException(String menssage) {
		super(menssage);
	}

}
