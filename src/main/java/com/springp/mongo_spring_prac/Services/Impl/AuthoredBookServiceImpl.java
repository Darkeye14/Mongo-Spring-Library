package com.springp.mongo_spring_prac.Services.Impl;

import com.springp.mongo_spring_prac.Services.AuthoredBookService;
import com.springp.mongo_spring_prac.domain.AuthoredBook;
import com.springp.mongo_spring_prac.domain.CreateUpdateBookRequest;

import java.util.List;
import java.util.Optional;

public class AuthoredBookServiceImpl implements AuthoredBookService {
    @Override
    public List<AuthoredBook> listBooks() {
        return List.of();
    }

    @Override
    public Optional<AuthoredBook> getBookByIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public AuthoredBook createUpdateBook(String bookIsbn, CreateUpdateBookRequest createUpdateBookRequest) {
        return null;
    }

    @Override
    public void deleteBook(String isbn) {

    }
}
