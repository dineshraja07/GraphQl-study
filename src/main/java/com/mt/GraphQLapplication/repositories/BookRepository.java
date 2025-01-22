package com.mt.GraphQLapplication.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mt.GraphQLapplication.models.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
}