package com.springp.mongo_spring_prac.exceptions;

import lombok.Getter;

public class AuthorNotFoundException extends B{
    private static final String ERROR_MESSAGE = "An Author with ID '%s' does not exist";

    @Getter
    private String authorId;

    public AuthorNotFoundException(final String authorId) {
        super(String.format(ERROR_MESSAGE, authorId));
        this.authorId = authorId;
    }

    public AuthorNotFoundException(final String authorId, final Throwable cause) {
        super(String.format(ERROR_MESSAGE, authorId), cause);
        this.authorId = authorId;
    }
}