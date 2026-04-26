package com.exorxis.careerconnect.service;
import com.exorxis.careerconnect.model.Job;
import com.exorxis.careerconnect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    @Autowired private JobRepository jobRepository;
    public List<Job> getAllJobs() { return jobRepository.findAll(); }
}