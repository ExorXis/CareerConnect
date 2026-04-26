package com.exorxis.careerconnect.repository;
import com.exorxis.careerconnect.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationRepository extends JpaRepository<Application, Long> { }