package com.example.hazelcastExample.service;

import com.example.hazelcastExample.domain.Book;
import com.example.hazelcastExample.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2

public class BookService {
    private final BookRepository bookRepository;

    @Cacheable(value = "books", key = "#isbn")   /// Load books
    public Book getBookNamebyIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Cacheable(value = "books", key = "#id")
    public Book findById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return bookRepository.save(book);

    }

    @Cacheable(value = "books")
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @CacheEvict(value = "books", key = "#id")
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }


    @CacheEvict(value = "books", allEntries=true)
    public Book save(Book book) {
        return bookRepository.save(book);
    }

}
