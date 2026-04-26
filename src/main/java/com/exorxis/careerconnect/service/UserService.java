package com.exorxis.careerconnect.service;

import com.exorxis.careerconnect.model.User;
import com.exorxis.careerconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String verifyLogin(String email, String password) {
        // 1. check for email
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            // 2. If user is found -> match password
            if (user.get().getPassword().equals(password)) {
                return "Success"; // password matched
            } else {
                return "Wrong Password"; // password didn't match
            }
        }
        return "User Not Found";
    }
}