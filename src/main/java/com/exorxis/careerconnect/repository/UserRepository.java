package com.exorxis.careerconnect.repository;

import com.exorxis.careerconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Save, Find, Delete etc. are automatically create by Spring Data JPA
    Optional<User> findByEmail(String email); // find email in DB
}