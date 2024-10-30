package com.springp.mongo_spring_prac.repository;

import com.springp.mongo_spring_prac.domain.documents.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepo extends MongoRepository<Author, String> {

}
