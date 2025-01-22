package com.mt.GraphQLapplication.Exceptions;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof BookNotFoundException) {
            return GraphqlErrorBuilder.newError()
              .errorType(ErrorType.NOT_FOUND)
              .message(ex.getMessage())
              .build();
        } 
        else if(ex instanceof AuthorNotFoundException)
        {
        	 return GraphqlErrorBuilder.newError()
                     .errorType(ErrorType.NOT_FOUND)
                     .message(ex.getMessage())
                     .build();
        }
        
        
        
        else {
            return null;
        }
    }
}