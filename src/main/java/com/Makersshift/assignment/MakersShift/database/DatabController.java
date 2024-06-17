package com.Makersshift.assignment.MakersShift.database;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Makersshift.assignment.MakersShift.repo.DatabRepository;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/user")
public class DatabController {
    @Autowired
    private DatabRepository databRepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(DatabController.class);

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Datab datab) {
        if (datab.getUsername() == null || datab.getUsername().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Username cannot be null or empty");
        }
        if (datab.getPassword() == null || datab.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be null or empty");
        }
        if (datab.getEmail() == null || datab.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email cannot be null or empty");
        }

        Datab savedUser = databRepository.save(datab);
        if (savedUser != null) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed");
        }
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchUser(@RequestParam String username) {
        logger.info("Fetching user with username: " + username);
        Datab datab = databRepository.findByUsername(username.trim().toUpperCase());
        if (datab != null) {
            logger.info("User found: " + datab.getUsername());
            return ResponseEntity.ok(datab);
        } else {
            logger.info("User not found for username: " + username);
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
