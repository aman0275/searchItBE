package com.searchit.demo.service;

import com.searchit.demo.exception.ResourceNotFoundException;
import com.searchit.demo.model.User;
import com.searchit.demo.repository.UserRepository;
import com.searchit.demo.dto.ExternalApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final RestTemplate restTemplate;

    @Value("${app.external-api.users-url}")
    private String externalApiUrl;

    @Override
    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000, multiplier = 2))
    public void loadUsersFromExternalApi() {
        log.info("Loading users from external API");
        ExternalApiResponse response = restTemplate.getForObject(externalApiUrl, ExternalApiResponse.class);
        
        if (response != null && response.getUsers() != null) {
            userRepository.saveAll(response.getUsers());
            log.info("Successfully loaded {} users", response.getUsers().size());
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    @Override
    public List<User> searchUsers(String searchTerm) {
        SearchSession searchSession = Search.session(entityManager);
        
        return searchSession.search(User.class)
                .where(f -> f.match()
                        .fields("firstName", "lastName", "ssn")
                        .matching(searchTerm))
                .fetchHits(20);
    }
} 