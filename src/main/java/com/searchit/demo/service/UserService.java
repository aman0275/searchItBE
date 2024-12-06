package com.searchit.demo.service;

import com.searchit.demo.model.User;
import java.util.List;

public interface UserService {
    void loadUsersFromExternalApi();
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> searchUsers(String searchTerm);
} 