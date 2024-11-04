package com.springp.mongo_spring_prac.controllers;

import com.springp.mongo_spring_prac.Services.AuthoredBookService;
import com.springp.mongo_spring_prac.domain.AuthoredBook;
import com.springp.mongo_spring_prac.domain.CreateUpdateBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/books")
public class AuthoredBooksController {
    private final AuthoredBookService authoredBookService;
    private final Mapper<AuthoredBook, AuthoredBookDto> bookMapper;
    private final Mapper<CreateUpdateBookRequest, CreateUpdateBookRequestDto> createUpdateRequestMapper;

    @GetMapping
    public List<AuthoredBookDto> listBooks() {
        // Ask the book service for all the books
        return authoredBookService.listBooks()
                // Stream convert the books into presentation layer objects
                .stream().map(bookMapper::mapTo)
                // Convert the stream of books into a list of books.
                .toList();
    }
    @GetMapping(path="/{isbn}")
    public ResponseEntity<AuthoredBookDto> getBookByIsbn(@PathVariable final String isbn) {
        // Look in the database for a book with the provided ISBN
        return authoredBookService.getBookByIsbn(isbn)
                .map(book ->
                        // Covert the found Book to a BookDTO
                        ResponseEntity.ok(bookMapper.mapTo(book))
                ).orElseGet(() ->
                        // Or return HTTP 404 NOT FOUND
                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
                );
    }
    @PutMapping(path = "/{isbn}")
    public AuthoredBookDto createUpdateBook(
            @PathVariable final String isbn,
            @RequestBody final CreateUpdateBookRequestDto requestBody
    ) {
        // Convert from the create/update Book request presentation layer to service layer object.
        final CreateUpdateBookRequest createUpdateBookRequest = createUpdateRequestMapper.mapFrom(requestBody);

        // Pass the converted object to the service layer to create/update the book.
        final AuthoredBook createUpdatedBook = authoredBookService.createUpdateBook(isbn, createUpdateBookRequest);

        // Map the returned Book to a presentation layer object and return.
        return bookMapper.mapTo(createUpdatedBook);
    }
    @DeleteMapping(path = "/{isbn}")
    public void deleteBook(@PathVariable final String isbn) {
        authoredBookService.deleteBook(isbn);
    }

}
