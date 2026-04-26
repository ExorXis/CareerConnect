package com.exorxis.careerconnect.repository;
import com.exorxis.careerconnect.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JobRepository extends JpaRepository<Job, Long> { }