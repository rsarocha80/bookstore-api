package com.dev.bookstore.exception;

public class StandardError {

	private Long timestamp;

	private Integer status;

	private String menssage;

	public StandardError(Long timestamp, Integer status, String menssage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.menssage = menssage;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
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
