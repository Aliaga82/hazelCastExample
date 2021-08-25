package com.example.hazelcastExample.repository;

import com.example.hazelcastExample.domain.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book>findAll();

    @Transactional
    @Modifying
    void deleteById(long id);
}
