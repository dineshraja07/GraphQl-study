package com.mt.GraphQLapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;

import com.mt.GraphQLapplication.models.Author;
import com.mt.GraphQLapplication.models.Book;
import com.mt.GraphQLapplication.repositories.AuthorRepository;
import com.mt.GraphQLapplication.repositories.BookRepository;



@Component
public class SeedData implements CommandLineRunner {
	
  @Autowired
	AuthorRepository authorRepository;
  @Autowired
	BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
 	Author author=new Author();
 	author.setId(2l);
 	author.setName("Martin");
	Book book=new Book();

	
	book.setId(5l);
	book.setName("Game of thrones");
	book.setPrice("1000");
	book.setAuthor(author);
	author.addBook(book);
	
	
	
	authorRepository.save(author);

	
	} 
	
}