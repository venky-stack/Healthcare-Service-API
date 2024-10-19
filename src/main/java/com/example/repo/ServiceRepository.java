package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.HealthcareService;

@Repository
public interface ServiceRepository extends MongoRepository<HealthcareService, String>{

}
