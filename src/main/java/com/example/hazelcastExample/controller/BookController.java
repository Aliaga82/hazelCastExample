package com.example.hazelcastExample.controller;

import com.example.hazelcastExample.domain.Book;
import com.example.hazelcastExample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
     private BookService bookService;
    @GetMapping (value = "/{isbn}")
    public Book findByIsbn(@PathVariable ("isbn") String isbn){
        return  bookService.getBookNamebyIsbn(isbn);
    }
}
