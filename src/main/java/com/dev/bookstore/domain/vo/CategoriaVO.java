package com.dev.bookstore.domain.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Campo NOME é obrigatório")
	@Length(min = 3, max = 100, message = "O campo NOME deve ter no mínimo 3 e máximo de 100")
	private String nome;

	@NotEmpty(message = "Campo DESCRIÇÃO é obrigatório")
	@Length(min = 10, max = 100, message = "O campo DESCRIÇÃO deve ter no mínimo de 10 e máximo de 100 caracteres")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
