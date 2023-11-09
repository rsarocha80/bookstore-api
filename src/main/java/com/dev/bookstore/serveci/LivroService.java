package com.dev.bookstore.serveci;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.bookstore.domain.dto.LivroDTO;
import com.dev.bookstore.domain.entity.Livro;
import com.dev.bookstore.domain.vo.LivroVO;
import com.dev.bookstore.exception.ObjectNotFoundException;
import com.dev.bookstore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		Livro livro = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo " + Livro.class.getName()));
		return livro;
	}

	public List<LivroDTO> findAll() {
		List<Livro> livro = repository.findAll();
		return livro.stream().map(x -> new LivroDTO(x)).collect(Collectors.toList());

	}

	@Transactional
	public Livro create(LivroVO vo) {
		Livro livro = repository
				.save(new Livro(null, vo.getTitulo(), vo.getNomeAutor(), vo.getTexto(), vo.getCategoria()));
		return livro;
	}

	@Transactional
	public LivroDTO update(Long id, LivroVO vo) {
		Livro obj = findById(id);
		obj.setId(vo.getId());
		obj.setNomeAutor(vo.getNomeAutor());
		obj.setTexto(vo.getTexto());
		obj.setTitulo(vo.getTitulo());
		obj.setCategoria(vo.getCategoria());
		repository.save(obj);

		return new LivroDTO(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);

	}

}
