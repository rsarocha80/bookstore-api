package com.dev.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.bookstore.domain.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
