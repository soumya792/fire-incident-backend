package com.fireincident.fire_incident_backend.service;

import com.fireincident.fire_incident_backend.entity.FireIncident;
import com.fireincident.fire_incident_backend.repository.FireIncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireIncidentService {

    private final FireIncidentRepository fireIncidentRepository;

    public FireIncidentService(FireIncidentRepository fireIncidentRepository) {
        this.fireIncidentRepository = fireIncidentRepository;
    }

    public List<FireIncident> getAllFireIncidents() {
        return fireIncidentRepository.findAll();
    }

    public FireIncident getFireIncidentById(Long id) {
        return fireIncidentRepository.findById(id).orElse(null);
    }

    public FireIncident createFireIncident(FireIncident fireIncident) {
        return fireIncidentRepository.save(fireIncident);
    }

    public void deleteFireIncident(Long id) {
        fireIncidentRepository.deleteById(id);
    }
}
