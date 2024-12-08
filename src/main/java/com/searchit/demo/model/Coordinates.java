package com.searchit.demo.model;

import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Coordinates {
    private Double lat;
    private Double lng;
} 