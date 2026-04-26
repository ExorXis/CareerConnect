package com.exorxis.careerconnect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // There can be multiple applications for a Job
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    // A User can apply many jobs
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status; // "Pending", "Accepted", "Rejected"

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}