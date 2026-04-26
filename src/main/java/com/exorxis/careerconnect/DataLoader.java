package com.exorxis.careerconnect;

import com.exorxis.careerconnect.model.Job;
import com.exorxis.careerconnect.model.User;
import com.exorxis.careerconnect.repository.JobRepository;
import com.exorxis.careerconnect.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, JobRepository jobRepository) {
        return args -> {
            // 1. Auto-User Generator
            if (userRepository.findByEmail("alok@exorxis.com").isEmpty()) {
                User testUser = new User();
                testUser.setEmail("alok@exorxis.com");
                testUser.setPassword("boss123");
                userRepository.save(testUser);
                System.out.println("✅ Master Key Ready: alok@exorxis.com | boss123");
            }

            // 2. Auto-Job Generator (Dukaan ka saamaan)
            if (jobRepository.count() == 0) {
                Job job1 = new Job();
                job1.setTitle("Senior Java Developer");
                job1.setCompanyName("Google India");
                job1.setDescription("Looking for a Spring Boot expert. Great opportunity for a passionate coder.");
                jobRepository.save(job1);

                Job job2 = new Job();
                job2.setTitle("Backend Engineer");
                job2.setCompanyName("Microsoft");
                job2.setDescription("Need strong logic in DSA and Java databases. Remote work available.");
                jobRepository.save(job2);

                Job job3 = new Job();
                job3.setTitle("Software Engineering Intern");
                job3.setCompanyName("TCS");
                job3.setDescription("Perfect starting role for MCA graduates of 2026. Learn and grow.");
                jobRepository.save(job3);

                System.out.println("✅ Dummy Jobs Loaded!");
            }
        };
    }
}