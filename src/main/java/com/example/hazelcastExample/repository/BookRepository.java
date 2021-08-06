package com.example.hazelcastExample.repository;

import com.example.hazelcastExample.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByIsbn(String isbn);
}
