package com.dev.bookstore.domain.dto;

import java.io.Serializable;

import com.dev.bookstore.domain.entity.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String titulo;

	private String nomeAutor;

	private String texto;

	public LivroDTO() {

	}

	public LivroDTO(String titulo, String nomeAutor, String texto) {
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
	}

	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getNomeAutor();
		this.texto = livro.getTexto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
