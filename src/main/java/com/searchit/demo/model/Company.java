package com.searchit.demo.model;

import lombok.Data;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;

@Data
@Embeddable
public class Company {
    private String department;
    private String name;
    private String title;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "address", column = @Column(name = "company_address")),
        @AttributeOverride(name = "city", column = @Column(name = "company_city")),
        @AttributeOverride(name = "state", column = @Column(name = "company_state")),
        @AttributeOverride(name = "stateCode", column = @Column(name = "company_state_code")),
        @AttributeOverride(name = "postalCode", column = @Column(name = "company_postal_code")),
        @AttributeOverride(name = "country", column = @Column(name = "company_country")),
        @AttributeOverride(name = "coordinates.lat", column = @Column(name = "company_coordinates_lat")),
        @AttributeOverride(name = "coordinates.lng", column = @Column(name = "company_coordinates_lng"))
    })
    private Address address;
} 