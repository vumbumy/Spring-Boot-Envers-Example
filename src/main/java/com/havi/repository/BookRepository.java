package com.havi.repository;

import com.havi.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface BookRepository extends JpaRepository<Book, Long>, RevisionRepository<Book, Long, Integer> {
}
