package com.mt.GraphQLapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mt.GraphQLapplication.Exceptions.AuthorNotFoundException;
import com.mt.GraphQLapplication.Exceptions.BookNotFoundException;
import com.mt.GraphQLapplication.models.Author;
import com.mt.GraphQLapplication.models.Book;
import com.mt.GraphQLapplication.repositories.AuthorRepository;
import com.mt.GraphQLapplication.repositories.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class GraphQlController {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;

	@SchemaMapping(typeName = "Query", field = "books")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@SchemaMapping(typeName = "Query", field = "authors")
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@SchemaMapping(typeName = "Query", field = "book")
	public Book getBook(@Argument Long id) {

		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));

	}

	@SchemaMapping(typeName = "Query", field = "author")
	public Author getAuthor(@Argument Long id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new AuthorNotFoundException("author not found with id " + id));
	}

	@SchemaMapping(typeName = "Mutation", field = "createBook")
	public Book createBook(@Argument Book book, @Argument Long author_id) {
		Author author = authorRepository.findById(author_id)
				.orElseThrow(() -> new AuthorNotFoundException("Author not found with id " + author_id));
		author.addBook(book);
		authorRepository.save(author);
		return book;
	}

	@SchemaMapping(typeName = "Mutation", field = "deleteBook")
	public String deleteBook(@Argument Long id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return "Book with " + id + " deleted";
		}
		return "Not found";
	}

	@SchemaMapping(typeName = "Mutation", field = "updateBook")
	public Book updateBook(@Argument Long id, @Argument Book book) {
		Book book1 = bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
		book1.setName(book.getName());
		book1.setPrice(book.getPrice());
		bookRepository.save(book1);
		return book1;
	}

	@SchemaMapping(typeName = "Mutation", field = "createAuthor")
	public Author createAuthor(@Argument Author author) {
		return authorRepository.save(author);
	}

	@SchemaMapping(typeName = "Mutation", field = "deleteAuthor")
	public String createAuthor(@Argument Long id) {
		if (authorRepository.existsById(id)) {
			authorRepository.deleteById(id);
			return "author with id " + id + " deleted";
		} else {
			return "author not found";
		}

	}

}
