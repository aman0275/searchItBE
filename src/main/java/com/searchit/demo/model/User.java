package com.searchit.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    private String maidenName;
    
    @NotNull
    private Integer age;
    
    @NotBlank
    private String gender;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String phone;
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String password;

    @JsonFormat(pattern = "yyyy-M-d")
    private LocalDate birthDate;
    
    private String image;
    
    private String bloodGroup;
    
    private Double height;
    
    private Double weight;
    
    private String eyeColor;

    @Embedded
    private Hair hair;

    private String ip;

    @Embedded
    private Address address;

    private String macAddress;
    
    private String university;

    @Embedded
    private Bank bank;

    @Embedded
    private Company company;

    private String ein;

    @NotBlank
    @FullTextField
    private String ssn;

    private String userAgent;

    @Embedded
    private Crypto crypto;

    @NotBlank
    private String role;
} 