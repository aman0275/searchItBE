package com.searchit.demo.model;

import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
@Indexed
public class User {
    @Id
    private Long id;

    @NotBlank
    @FullTextField
    private String firstName;

    @NotBlank
    @FullTextField
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @FullTextField
    private String ssn;
} 