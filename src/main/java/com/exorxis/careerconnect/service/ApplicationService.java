package com.exorxis.careerconnect.service;
import com.exorxis.careerconnect.model.*;
import com.exorxis.careerconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired private ApplicationRepository appRepo;
    public String applyForJob(User user, Job job) {
        Application app = new Application();
        app.setUser(user);
        app.setJob(job);
        app.setStatus("Applied");
        appRepo.save(app);
        return "Application Successful!";
    }
}