package com.searchit.demo.model;

import lombok.Data;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Embeddable
public class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    
    @Embedded
    private Coordinates coordinates;
    
    private String country;
} 