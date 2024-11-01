package com.springp.mongo_spring_prac.Services;

import com.springp.mongo_spring_prac.domain.AuthoredBook;
import com.springp.mongo_spring_prac.domain.CreateUpdateBookRequest;

import java.util.List;
import java.util.Optional;

public interface AuthoredBookService {
    List<AuthoredBook> listBooks();
    Optional<AuthoredBook> getBookByIsbn(String isbn);

    AuthoredBook createUpdateBook(String bookIsbn, CreateUpdateBookRequest createUpdateBookRequest);

    void deleteBook(String isbn);
}
