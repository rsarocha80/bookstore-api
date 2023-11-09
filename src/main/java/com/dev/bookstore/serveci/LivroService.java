package com.dev.bookstore.serveci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.bookstore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

}
