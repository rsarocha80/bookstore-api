package com.dev.bookstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.bookstore.domain.dto.CategoriaDTO;
import com.dev.bookstore.domain.entity.Categoria;
import com.dev.bookstore.serveci.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria cat = categoriaService.findById(id);
		return ResponseEntity.ok().body(cat);

	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> cat = categoriaService.findAll();
		return ResponseEntity.ok().body(cat);

	}

}
