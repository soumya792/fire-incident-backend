package com.fireincident.fire_incident_backend.controller;

import com.fireincident.fire_incident_backend.entity.FireIncident;
import com.fireincident.fire_incident_backend.service.FireIncidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fire-incidents")
@CrossOrigin(origins = "http://localhost:5173")
public class FireIncidentController {

    private final FireIncidentService fireIncidentService;

    public FireIncidentController(FireIncidentService fireIncidentService) {
        this.fireIncidentService = fireIncidentService;
    }

    @GetMapping
    public List<FireIncident> getAllFireIncidents() {
        return fireIncidentService.getAllFireIncidents();
    }

    @GetMapping("/{id}")
    public FireIncident getFireIncidentById(@PathVariable Long id) {
        return fireIncidentService.getFireIncidentById(id);
    }

    @PostMapping
    public FireIncident createFireIncident(@RequestBody FireIncident fireIncident) {
        return fireIncidentService.createFireIncident(fireIncident);
    }

    @DeleteMapping("/{id}")
    public void deleteFireIncident(@PathVariable Long id) {
        fireIncidentService.deleteFireIncident(id);
    }
}
