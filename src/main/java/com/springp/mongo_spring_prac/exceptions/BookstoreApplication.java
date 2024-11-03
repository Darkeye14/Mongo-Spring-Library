package com.springp.mongo_spring_prac.exceptions;

public class BookstoreApplication extends RuntimeException{
    public BookstoreApplication() {
    }

    public BookstoreApplication(String message) {
        super(message);
    }

    public BookstoreApplication(String message, Throwable cause) {
        super(message, cause);
    }
}
