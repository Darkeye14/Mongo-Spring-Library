package com.springp.mongo_spring_prac.Services.Impl;

import com.springp.mongo_spring_prac.Services.AuthorService;
import com.springp.mongo_spring_prac.domain.CreateUpdateAuthorRequest;
import com.springp.mongo_spring_prac.domain.documents.Author;
import com.springp.mongo_spring_prac.repository.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    @Override
    public List<Author> listAuthors() {
        return List.of();
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return Optional.empty();
    }

    @Override
    public Author createUpdateAuthor(String authorId, CreateUpdateAuthorRequest createUpdateauthorRequest) {
        return null;
    }

    @Override
    public void deleteAuthor(String id) {

    }
}
