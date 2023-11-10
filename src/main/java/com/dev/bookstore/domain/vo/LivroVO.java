package com.dev.bookstore.domain.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.dev.bookstore.domain.entity.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class LivroVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Campo Título é obrigatório")
	@Length(min = 3, max = 100, message = "O campo Título deve ter no mínimo de 10 e máximo de 100 caracteres")
	private String titulo;

	@NotEmpty(message = "Campo NOME DO AUTOR é obrigatório")
	@Length(min = 10, max = 100, message = "O campo NOME DO AUTOR deve ter no mínimo de 10 e máximo de 100 caracteres")
	private String nomeAutor;

	@NotEmpty(message = "Campo TEXTO é obrigatório")
	@Length(min = 10, max = 2000, message = "O campo TEXTO deve ter no mínimo de 10 e máximo de 100 caracteres")
	private String texto;

	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
