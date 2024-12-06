package com.searchit.demo.dto;

import com.searchit.demo.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ExternalApiResponse {
    private List<User> users;
    private int total;
    private int skip;
    private int limit;
} 