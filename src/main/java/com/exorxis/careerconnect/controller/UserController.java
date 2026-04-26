package com.exorxis.careerconnect.controller;

import com.exorxis.careerconnect.dto.LoginRequest;
import com.exorxis.careerconnect.model.User;
import com.exorxis.careerconnect.service.UserService;
import com.exorxis.careerconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Repository injected
    @Autowired
    private UserRepository userRepository;

    // Test Endpoint - Checking if the server is running
    @GetMapping("/ping")
    public ResponseEntity<String> pingServer() {
        return ResponseEntity.ok("CareerConnect Server is running");
    }

    // User Registration Endpoint
    // Naya User Register karne ke liye
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) { // check if user already exists
            return "Email already exists!";
        }
        userRepository.save(user); // register new user
        return "Registration Successful! Now you can login.";
    }

    // Helper
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        // Helper will check for email and password
        return userService.verifyLogin(loginRequest.getEmail(), loginRequest.getPassword());
    }
}