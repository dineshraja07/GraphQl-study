package com.mt.GraphQLapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.GraphQLapplication.models.Book;
import com.mt.GraphQLapplication.repositories.BookRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    
    @GetMapping("/book")
    public List<Book> getBooks()
    {
    	List<Book> books=bookRepository.findAll();
    	return books;
    }
    
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id)
    {
    	return bookRepository.findById(id).get();
    }
}
