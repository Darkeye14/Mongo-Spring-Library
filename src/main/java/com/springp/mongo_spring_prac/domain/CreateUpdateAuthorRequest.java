package com.springp.mongo_spring_prac.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateAuthorRequest {
    private String givenName;
    private String familyName;
    private String description;

}