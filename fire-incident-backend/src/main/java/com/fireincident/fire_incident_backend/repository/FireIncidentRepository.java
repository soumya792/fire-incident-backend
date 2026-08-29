package com.fireincident.fire_incident_backend.repository;

import com.fireincident.fire_incident_backend.entity.FireIncident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireIncidentRepository extends JpaRepository<FireIncident, Long> {
}
