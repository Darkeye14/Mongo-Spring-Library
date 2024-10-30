package com.springp.mongo_spring_prac.repository;

import com.springp.mongo_spring_prac.domain.documents.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, String> {
}
