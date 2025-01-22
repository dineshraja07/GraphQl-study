package com.mt.GraphQLapplication.Exceptions;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String str) {
		super(str);
	}

}
