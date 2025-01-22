package com.mt.GraphQLapplication.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.GraphQLapplication.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	  
}