package com.example.hazelcastExample.controller;

import com.example.hazelcastExample.domain.Book;
import com.example.hazelcastExample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(value = "/save")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping(value = "/isbn/{isbn}")
    public Book findByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getBookNamebyIsbn(isbn);
    }

    @GetMapping(value = "/id/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @GetMapping(value = "/findAll")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping(value = "/upDateBook/(id}")
    public Book update(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
