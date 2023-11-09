package com.dev.bookstore.exception;

import java.time.LocalDateTime;

public class StandardError {

	private LocalDateTime timestamp;

	private Integer status;

	private String menssage;

	public StandardError(LocalDateTime timestamp, Integer status, String menssage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.menssage = menssage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

}
