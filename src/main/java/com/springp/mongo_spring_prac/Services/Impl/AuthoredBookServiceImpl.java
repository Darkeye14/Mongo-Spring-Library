package com.springp.mongo_spring_prac.Services.Impl;

import com.springp.mongo_spring_prac.Services.AuthoredBookService;
import com.springp.mongo_spring_prac.domain.AuthoredBook;
import com.springp.mongo_spring_prac.domain.CreateUpdateBookRequest;
import com.springp.mongo_spring_prac.domain.documents.Author;
import com.springp.mongo_spring_prac.domain.documents.Book;
import com.springp.mongo_spring_prac.repository.AuthorRepo;
import com.springp.mongo_spring_prac.repository.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthoredBookServiceImpl implements AuthoredBookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;



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
        bookRepo.deleteById(isbn);
    }
    private AuthoredBook buildAuthoredBook(final Book book, final Author author){
        return AuthoredBook.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .datePublished(book.getDatePublished())
                .author(author)
                .created(book.getCreated())
                .lastUpdated(book.getLastUpdated())
                .build();
    }
}
