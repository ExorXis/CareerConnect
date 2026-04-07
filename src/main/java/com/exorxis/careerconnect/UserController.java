package com.exorxis.careerconnect;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // 1. Test Endpoint - Checking if the server is running
    @GetMapping("/ping")
    public ResponseEntity<String> pingServer() {
        return ResponseEntity.ok("CareerConnect Server is running");
    }

    // 2. User Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody String userData) {
        // Service Layer and Database save logic
        System.out.println("New User Data received: " + userData);
        return ResponseEntity.ok("Registration successful! Welcome to CareerConnect.");
    }
}