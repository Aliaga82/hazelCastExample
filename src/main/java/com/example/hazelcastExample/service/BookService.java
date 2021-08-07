package com.example.hazelcastExample.service;

import com.example.hazelcastExample.domain.Book;
import com.example.hazelcastExample.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2

public class BookService {
    private final BookRepository bookRepository;

    @Cacheable(value = "books", key = "#isbn")   /// Load books
    public Book getBookNamebyIsbn( String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    public Book findById (Long id){
        return bookRepository.findById(id).orElse(null);
    }
}
