package com.searchit.demo.config;

import com.searchit.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserService userService;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            log.info("Starting data initialization...");
            userService.loadUsersFromExternalApi();
            log.info("Data initialization completed.");
        };
    }
} 