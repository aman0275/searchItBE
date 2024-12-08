package com.searchit.demo.model;

import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Hair {
    private String color;
    private String type;
} 