package com.mt.GraphQLapplication.Exceptions;

public class AuthorNotFoundException extends RuntimeException {
	public AuthorNotFoundException(String str) {
		super(str);
	}
}
