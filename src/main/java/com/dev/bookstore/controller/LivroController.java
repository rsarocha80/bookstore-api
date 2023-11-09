package com.dev.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.bookstore.domain.dto.LivroDTO;
import com.dev.bookstore.domain.entity.Livro;
import com.dev.bookstore.domain.vo.LivroVO;
import com.dev.bookstore.serveci.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro livro = service.findById(id);
		return ResponseEntity.ok().body(livro);

	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<LivroDTO> livroDTO = service.findAll();
		return ResponseEntity.ok().body(livroDTO);

	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestBody LivroVO vo) {
		Livro livro = service.create(vo);
		return ResponseEntity.ok().body(livro);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> create(@PathVariable Long id, @RequestBody LivroVO vo) {
		LivroDTO dto = service.update(id,vo);
		return ResponseEntity.ok().body(dto);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}

}
