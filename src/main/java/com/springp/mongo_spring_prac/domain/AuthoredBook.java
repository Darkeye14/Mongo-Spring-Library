package com.springp.mongo_spring_prac.domain;

import com.springp.mongo_spring_prac.domain.documents.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthoredBook {
    @Id
    private String isbn;
    private String title;
    private LocalDate datePublished;
    private Author author;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
}
