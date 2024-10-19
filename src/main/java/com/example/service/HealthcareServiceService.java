package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.HealthcareService;
import com.example.repo.ServiceRepository;

@Service
public class HealthcareServiceService {

	@Autowired
    private ServiceRepository repository;

    public HealthcareService addService(HealthcareService service) {
        return repository.save(service);
    }

    public List<HealthcareService> getAllServices() {
        return repository.findAll();
    }

    public Optional<HealthcareService> updateService(String id, HealthcareService service) {
        Optional<HealthcareService> existingService = repository.findById(id);
        if (existingService.isPresent()) {
            HealthcareService updatedService = existingService.get();
            updatedService.setServiceName(service.getServiceName());
            updatedService.setDescription(service.getDescription());
            updatedService.setPrice(service.getPrice());
            return Optional.of(repository.save(updatedService));
        }
        return Optional.empty();
    }

    public void deleteService(String id) {
        repository.deleteById(id);
    }
}
