package com.searchit.demo.model;

import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Bank {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
} 