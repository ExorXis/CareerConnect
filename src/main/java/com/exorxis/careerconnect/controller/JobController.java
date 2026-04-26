package com.exorxis.careerconnect.controller;

import com.exorxis.careerconnect.model.Application;
import com.exorxis.careerconnect.model.Job;
import com.exorxis.careerconnect.model.User;
import com.exorxis.careerconnect.repository.ApplicationRepository;
import com.exorxis.careerconnect.repository.JobRepository;
import com.exorxis.careerconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired private JobRepository jobRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ApplicationRepository applicationRepository;

    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobRepository.findAll(); // fetch all jobs
    }

    @PostMapping("/add")
    public String addJob(@RequestBody Job job) {
        jobRepository.save(job);
        return "Job Posted Successfully!";
    }

    // Link User and Job in database
    @PostMapping("/apply/{jobId}")
    public String applyForJob(@PathVariable Long jobId, @RequestParam String email) {
        // 1. Find User
        User user = userRepository.findByEmail(email).orElse(null);
        // 2. Find Job (applied)
        Job job = jobRepository.findById(jobId).orElse(null);

        if (user != null && job != null) {
            Application app = new Application();
            app.setUser(user);
            app.setJob(job);
            app.setStatus("Applied");
            applicationRepository.save(app);
            return "Application Sent! HR will review it soon.";
        }
        return "Error: User or Job not found!";
    }

    // To bring all applications
    @GetMapping("/applications")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll(); 
    }
}