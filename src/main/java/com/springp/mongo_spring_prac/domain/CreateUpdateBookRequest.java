package com.springp.mongo_spring_prac.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateBookRequest {
    private String title;
    private LocalDate datePublished;
    private String authorId;
}