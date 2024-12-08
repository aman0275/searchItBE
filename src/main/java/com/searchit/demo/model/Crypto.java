package com.searchit.demo.model;

import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Crypto {
    private String coin;
    private String wallet;
    private String network;
} 