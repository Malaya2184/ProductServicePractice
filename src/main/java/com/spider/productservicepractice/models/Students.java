package com.spider.productservicepractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Students {

    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
