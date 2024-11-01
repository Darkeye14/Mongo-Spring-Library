package com.springp.mongo_spring_prac.Services.Impl;

import com.springp.mongo_spring_prac.Services.AuthorService;
import com.springp.mongo_spring_prac.domain.CreateUpdateAuthorRequest;
import com.springp.mongo_spring_prac.domain.documents.Author;
import com.springp.mongo_spring_prac.repository.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    @Override
    public List<Author> listAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return authorRepo.findById(id);
    }

    @Override
    public Author createUpdateAuthor(String authorId, CreateUpdateAuthorRequest createUpdateauthorRequest) {
        return authorRepo.findById(authorId).map(
                existingAuthor ->{
                    final Author updateAuthor = Author.builder()
                            .id(authorId)
                            .givenName(createUpdateauthorRequest.getGivenName())
                            .familyName(createUpdateauthorRequest.getFamilyName())
                            .description(createUpdateauthorRequest.getDescription())
                            .created(existingAuthor.getCreated())
                            .lastUpdated(LocalDateTime.now())
                            .build();
                    return authorRepo.save(updateAuthor);
                }
        ).orElseGet(
                () -> {
                    final LocalDateTime now = LocalDateTime.now();
                    final Author newAuthor = Author.builder()
                            .id(authorId)
                            .givenName(createUpdateauthorRequest.getGivenName())
                            .familyName(createUpdateauthorRequest.getFamilyName())
                            .description(createUpdateauthorRequest.getDescription())
                            .created(now)
                            .lastUpdated(now)
                            .build();
                    return authorRepo.save(newAuthor);
                }
        );


    }

    @Override
    public void deleteAuthor(String id) {
        authorRepo.deleteById(id);
    }
}
