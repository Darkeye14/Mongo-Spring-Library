package com.springp.mongo_spring_prac.Services;

import com.springp.mongo_spring_prac.domain.documents.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> getAuthorById(String id);
    Author createUpdateAuthor(String authorId, CreateUpdateauthorRequest createUpdateauthorRequest );
    void deleteAuthor(String id);
}
