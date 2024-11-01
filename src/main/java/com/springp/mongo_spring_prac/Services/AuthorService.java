package com.springp.mongo_spring_prac.Services;

import com.springp.mongo_spring_prac.domain.documents.Author;
import com.springp.mongo_spring_prac.domain.CreateUpdateAuthorRequest;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> getAuthorById(String id);
    Author createUpdateAuthor(String authorId,CreateUpdateAuthorRequest createUpdateauthorRequest );
    void deleteAuthor(String id);
}
