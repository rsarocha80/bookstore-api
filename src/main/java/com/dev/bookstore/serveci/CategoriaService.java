package com.dev.bookstore.serveci;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.bookstore.domain.dto.CategoriaDTO;
import com.dev.bookstore.domain.entity.Categoria;
import com.dev.bookstore.domain.vo.CategoriaVO;
import com.dev.bookstore.exception.ObjectNotFoundException;
import com.dev.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	public CategoriaDTO create(final CategoriaVO vo) {
		Categoria cat = categoriaRepository.save(new Categoria(null, vo.getNome(), vo.getDescricao()));
		return new CategoriaDTO(cat);

	}

	@Transactional
	public CategoriaDTO update(final Long id, final CategoriaVO vo) {
		Categoria cat = findById(id);
		cat.setNome(vo.getNome());
		cat.setDescricao(vo.getDescricao());
		return new CategoriaDTO(cat);

	}

	@Transactional(readOnly = true)
	public List<CategoriaDTO> findAll() {
		List<Categoria> cat = categoriaRepository.findAll();
		return cat.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		Categoria cat = obj//
				.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! id: " + id + ", tipo " + Categoria.class.getName()));
		return cat;

	}

	public void delete(Long id) {
		findById(id);
		categoriaRepository.deleteById(id);

	}

}
