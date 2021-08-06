package com.example.hazelcastExample.service;

import com.example.hazelcastExample.domain.Book;
import com.example.hazelcastExample.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BookService {
    private final BookRepository bookRepository;

    @Cacheable("books")
    public Book getBookNamebyIsbn( String isbn) {
        return findBookInslowSource(isbn);
    }
    public Book findBookInslowSource(String isbn){
        try {
           Thread.sleep(3000);
        } catch (InterruptedException e){
          e.printStackTrace();
        }
        return bookRepository.findByIsbn(isbn);
    }
}
