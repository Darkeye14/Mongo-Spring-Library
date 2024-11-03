package com.springp.mongo_spring_prac.Services.Impl;

import com.springp.mongo_spring_prac.Services.AuthoredBookService;
import com.springp.mongo_spring_prac.domain.AuthoredBook;
import com.springp.mongo_spring_prac.domain.CreateUpdateBookRequest;
import com.springp.mongo_spring_prac.domain.documents.Author;
import com.springp.mongo_spring_prac.domain.documents.Book;
import com.springp.mongo_spring_prac.exceptions.AuthorNotFoundException;
import com.springp.mongo_spring_prac.repository.AuthorRepo;
import com.springp.mongo_spring_prac.repository.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return bookRepo.findById(isbn).map(
                book -> {
                    final String authorId = book.getAuthorId();
                    final Author author = authorRepo.findById(authorId).orElseThrow(() ->
                            new AuthorNotFoundException(authorId)
                    );

                    return buildAuthoredBook(book, author);
                }
        );
    }

    @Override
    public AuthoredBook createUpdateBook(String bookIsbn, CreateUpdateBookRequest createUpdateBookRequest) {
        final String authorId = createUpdateBookRequest.getAuthorId();

        final Optional<Author> existingAuthor = authorRepo.findById(authorId);
        if (existingAuthor.isEmpty()) {
            throw new AuthorNotFoundException(authorId);
        }

        final Book book = bookRepo.findById(bookIsbn).map(existingBook -> {

            final Book updatedBook = Book.builder()
                    .isbn(bookIsbn)
                    .title(createUpdateBookRequest.getTitle())
                    .datePublished(createUpdateBookRequest.getDatePublished())
                    .authorId(authorId)
                    .created(existingBook.getCreated())
                    .lastUpdated(LocalDateTime.now())
                    .build();
            return bookRepo.save(updatedBook);
        }).orElseGet(() -> {
            // Create a new Book
            final LocalDateTime now = LocalDateTime.now();
            final Book newBook = Book.builder()
                    .isbn(bookIsbn)
                    .title(createUpdateBookRequest.getTitle())
                    .datePublished(createUpdateBookRequest.getDatePublished())
                    .authorId(authorId)
                    .created(now)
                    .lastUpdated(now)
                    .build();
            return bookRepo.save(newBook);
        });

        return buildAuthoredBook(book, existingAuthor.get());
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
