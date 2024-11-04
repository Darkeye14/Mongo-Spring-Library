package com.springp.mongo_spring_prac.controllers;

import com.springp.mongo_spring_prac.Services.AuthoredBookService;
import com.springp.mongo_spring_prac.domain.AuthoredBook;
import com.springp.mongo_spring_prac.domain.CreateUpdateBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
